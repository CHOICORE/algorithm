class Solution {
    long lowerBound(int[] nums, int low, int high, int element) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {

            long low = lowerBound(
                    nums,
                    i + 1,
                    nums.length - 1,
                    lower - nums[i]
            );

            long high = lowerBound(
                    nums,
                    i + 1,
                    nums.length - 1,
                    upper - nums[i] + 1
            );

            ans += (high - low);
        }
        return ans;
    }
}