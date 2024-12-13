class Solution {
    public long findScore(int[] nums) {
        long answer = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
                i++;
            }
            for (int j = i; j >= start; j -= 2) {
                answer += nums[j];
            }
        }
        return answer;
    }
}