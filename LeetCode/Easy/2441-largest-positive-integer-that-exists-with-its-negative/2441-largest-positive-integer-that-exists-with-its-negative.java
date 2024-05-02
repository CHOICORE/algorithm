class Solution {
    public int findMaxK(int[] nums) {
        int answer = -1;

        for (int i : nums) {
            for (int j : nums) {
                if (i == -j) {
                    answer = Math.max(answer, Math.abs(i));
                }
            }
        }

        return answer;
    }
}