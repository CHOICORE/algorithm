class Solution {
    Integer[][][] dp;
    Integer n;
    Integer m;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][m];
        return helper(0, 0, m - 1);
    }

    private int helper(int r, int c1, int c2) {
        if (r == n || c1 < 0 || c2 >= m) return 0;
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];

        int maxCherry = 0;
        for (int i = -1; i < 2; ++i)
            for (int j = -1; j < 2; ++j)
                if (c1 + i <= c2 + j)
                    maxCherry = Math.max(maxCherry, helper(r + 1, c1 + i, c2 + j));

        return dp[r][c1][c2] = maxCherry + grid[r][c1] + (c1 != c2 ? grid[r][c2] : 0);
    }
}