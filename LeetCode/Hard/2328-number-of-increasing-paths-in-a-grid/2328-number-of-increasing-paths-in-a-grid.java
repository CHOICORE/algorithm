class Solution {
    int mod = 1_000_000_007;

    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += real(i, j, n, m, grid, dp);
                ans %= mod;
            }
        }
        return ans;

    }

    int real(int i, int j, int n, int m, int[][] grid, int[][] dp) {

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int c = 0;
        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j]) {
            c += 1 + real(i - 1, j, n, m, grid, dp);
        }
        if (j - 1 >= 0 && grid[i][j] < grid[i][j - 1]) {
            c += 1 + real(i, j - 1, n, m, grid, dp);
        }
        if (i + 1 < n && grid[i][j] < grid[i + 1][j]) {
            c += 1 + real(i + 1, j, n, m, grid, dp);
        }
        if (j + 1 < m && grid[i][j] < grid[i][j + 1]) {
            c += 1 + real(i, j + 1, n, m, grid, dp);
        }
        c %= mod;
        return dp[i][j] = c;

    }
}