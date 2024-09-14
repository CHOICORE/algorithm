class Solution {

    public int longestSubarray(int[] nums) {
        int maxVal = 0, answer = 0, currentStreak = 0;

        for (int num : nums) {
            if (maxVal < num) {
                maxVal = num;
                answer = currentStreak = 0;
            }

            if (maxVal == num) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }

            answer = Math.max(answer, currentStreak);
        }
        return answer;
    }
}