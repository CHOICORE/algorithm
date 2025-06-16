class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int answer = -1, tmp = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > tmp) {
                answer = Math.max(answer, nums[i] - tmp);
            } else {
                tmp = nums[i];
            }
        }
        return answer;
    }
}