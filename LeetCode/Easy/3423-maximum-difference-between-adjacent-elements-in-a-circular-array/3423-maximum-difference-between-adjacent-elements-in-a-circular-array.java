class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int answer = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i) {
            answer = Math.max(answer, Math.abs(nums[i] - nums[i + 1]));
        }
        return answer;
    }
}