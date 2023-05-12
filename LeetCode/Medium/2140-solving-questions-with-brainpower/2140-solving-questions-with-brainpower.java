class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = questions[i][0];
            if (i + questions[i][1] + 1 < n) {
                dp[i] = Math.max(dp[i], (long) questions[i][0] + dp[i + questions[i][1] + 1]);
            }
            if (i + 1 < n) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }
}