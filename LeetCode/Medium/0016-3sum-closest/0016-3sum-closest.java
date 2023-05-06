class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE, result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] * 3 >= target) {
                int sum = nums[i] + nums[i + 1] + nums[i + 2];
                if (sum - target < minDiff) {
                    result = sum;
                }
                break;
            }
            int sum = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
            if (sum <= target) {
                if (target - sum < minDiff) {
                    minDiff = target - sum;
                    result = sum;
                }
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < minDiff) {
                    result = sum;
                    minDiff = Math.abs(sum - target);
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}