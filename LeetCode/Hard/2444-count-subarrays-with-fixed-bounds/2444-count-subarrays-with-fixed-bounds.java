class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long answer = 0;
        int tmp = -1, left = -1, right = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                tmp = i;
            }

            if (nums[i] == minK) {
                left = i;
            }

            if (nums[i] == maxK) {
                right = i;
            }

            answer += Math.max(0, Math.min(left, right) - tmp);
        }

        return answer;
    }
}
