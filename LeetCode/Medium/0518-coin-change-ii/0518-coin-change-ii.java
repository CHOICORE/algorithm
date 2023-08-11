class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(amount, n - 1, coins, dp);
    }

    int helper(int amount, int x, int[] coins, int[][] dp) {
        if (x == 0) {
            if (amount % coins[x] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[x][amount] != -1)
            return dp[x][amount];
        int take = 0;
        if (coins[x] <= amount) {
            take = helper(amount - coins[x], x, coins, dp);
        }
        int nottake = helper(amount, x - 1, coins, dp);
        return dp[x][amount] = take + nottake;
    }
}