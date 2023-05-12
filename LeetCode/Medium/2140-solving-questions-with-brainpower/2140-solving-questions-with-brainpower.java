class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[][] dp = new long[n][2];
        dp[n - 1][0] = 0;
        dp[n - 1][1] = questions[n - 1][0];
        long sol = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]);
            int back = i + questions[i][1] + 1;
            if (back < n) {
                dp[i][1] = Math.max(dp[back][0], dp[back][1]) + questions[i][0];
            } else {
                dp[i][1] = questions[i][0];
            }
            sol = Math.max(dp[i][0], dp[i][1]);
        }
        return sol;

    }
}