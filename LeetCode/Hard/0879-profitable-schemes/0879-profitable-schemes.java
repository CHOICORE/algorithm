class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        int mod = (int)1e9+7;
        for (int k = 0; k < group.length; k++) {
            for (int i = n; i >= group[k]; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i-group[k]][Math.max(0, j-profit[k])]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[i][minProfit]) % mod;
        }
        return ans;
    }
}
