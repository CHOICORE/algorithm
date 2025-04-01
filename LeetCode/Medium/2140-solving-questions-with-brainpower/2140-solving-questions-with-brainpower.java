class Solution {
    private long helper(int i, int[][] questions, long[] dp, int n) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        long take = questions[i][0] + helper(i + questions[i][1] + 1, questions, dp, n);
        long dont = helper(i + 1, questions, dp, n);

        return dp[i] = Math.max(take, dont);

    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return helper(0, questions, dp, n);
    }
}