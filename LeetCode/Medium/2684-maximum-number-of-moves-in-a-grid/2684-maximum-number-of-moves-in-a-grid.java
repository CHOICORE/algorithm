class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        int maxMoves = 0;
        for (int i = 0; i < n; i++) {

            maxMoves = Math.max(maxMoves, solve(i, 0, n, m, grid, dp));

        }

        return maxMoves;
    }

    private int solve(int i, int j, int n, int m, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (i - 1 >= 0 && j + 1 < m && grid[i][j] < grid[i - 1][j + 1]) {
            ans = Math.max(ans, 1 + solve(i - 1, j + 1, n, m, grid, dp));
        }
        if (j + 1 < m && grid[i][j] < grid[i][j + 1]) {
            ans = Math.max(ans, 1 + solve(i, j + 1, n, m, grid, dp));
        }
        if (i + 1 < n && j + 1 < m && grid[i][j] < grid[i + 1][j + 1]) {
            ans = Math.max(ans, 1 + solve(i + 1, j + 1, n, m, grid, dp));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }
}