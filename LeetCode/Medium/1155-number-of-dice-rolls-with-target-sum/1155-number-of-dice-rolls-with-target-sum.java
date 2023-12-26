class Solution {
    int[][] dp;
    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        if (n == 0 && target == 0)
            return 1;
        if (target < n || n * k < target)
            return 0;
        dp = new int[n + 1][target + 1];
        return f(n, k, target);
    }

    public int f(int n, int k, int target) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (target < n || n * k < target) {
            return 0;
        }
        if (dp[n][target] != 0) {
            return dp[n][target];
        }
        int answer = 0;
        for (int i = 1; i <= k; i++) {
            if (target < i) break;
            answer = (answer + f(n - 1, k, target - i) % MOD) % MOD;
        }
        dp[n][target] = answer;
        return answer;
    }
}