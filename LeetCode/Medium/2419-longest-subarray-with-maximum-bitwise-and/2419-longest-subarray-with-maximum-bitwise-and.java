class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, r = 0, currentStreak = 0;
        for (int num : nums) {
            if (maxVal < num) {
                maxVal = num;
                r = currentStreak = 0;
            }

            if (maxVal == num) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }

            r = Math.max(r, currentStreak);
        }
        return r;
    }
}