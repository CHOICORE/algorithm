class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = -1;
        int right = -1;
        int c = -1;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                c = i;
            }

            if (nums[i] == minK) {
                left = i;
            }

            if (nums[i] == maxK) {
                right = i;
            }

            int smaller = Math.min(left, right);
            int temp = smaller - c;
            ans += Math.max(temp, 0);
        }

        return ans;
    }
}