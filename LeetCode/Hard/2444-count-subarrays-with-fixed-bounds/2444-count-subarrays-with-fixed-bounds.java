class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1, max = -1, left = -1, right = 0;
        long answer = 0;
        while (right < nums.length) {
            if (nums[right] < minK || nums[right] > maxK) {
                min = right;
                max = right;
                left = right;
            }
            min = nums[right] == minK ? right : min;
            max = nums[right] == maxK ? right : max;
            answer += Math.min(min, max) - left;
            right++;
        }
        return answer;
    }
}