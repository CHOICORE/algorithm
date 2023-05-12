class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long ans = 0;
        for (int i = 0; i < dp.length; i++) {
            long prev = i == 0 ? 0L : dp[i - 1] - (long) questions[i - 1][0];
            dp[i] = Math.max(dp[i], prev);
            dp[i] += (long) questions[i][0];
            ans = Math.max(ans, dp[i]);
            int nextIdx = i + 1 + questions[i][1];
            if (nextIdx < dp.length) {
                dp[nextIdx] = Math.max(dp[nextIdx], dp[i]);
            }
        }
        return ans;
    }
}