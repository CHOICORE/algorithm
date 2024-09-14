class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, answer = 0, currentStreak = 0;

        for (int num : nums) {
            if (max < num) {
                max = num;
                answer = currentStreak = 0;
            }

            if (max == num) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }

            answer = Math.max(answer, currentStreak);
        }
        return answer;
    }
}