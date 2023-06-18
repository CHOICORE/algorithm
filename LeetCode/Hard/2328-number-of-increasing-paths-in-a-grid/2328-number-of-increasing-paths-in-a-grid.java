class Solution {
    private int[][] matrix;
    private int rowLength, columnLength;
    private int[][] dp;
    private final int mod = (int) (1e9 + 7);

    public int longestIncreasingPath(int row, int col) {
        int longestPath = 1;
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        if (row + 1 < this.rowLength && this.matrix[row + 1][col] > this.matrix[row][col]) {
            longestPath = (longestPath + longestIncreasingPath(row + 1, col)) % mod;
        }

        if (row - 1 >= 0 && this.matrix[row - 1][col] > this.matrix[row][col]) {
            longestPath = (longestPath + longestIncreasingPath(row - 1, col)) % mod;
        }

        if (col + 1 < this.columnLength && this.matrix[row][col + 1] > this.matrix[row][col]) {
            longestPath = (longestPath + longestIncreasingPath(row, col + 1)) % mod;
        }

        if (col - 1 >= 0 && this.matrix[row][col - 1] > this.matrix[row][col]) {
            longestPath = (longestPath + longestIncreasingPath(row, col - 1)) % mod;
        }

        dp[row][col] = longestPath;
        return longestPath;
    }

    public int countPaths(int[][] grid) {
        this.matrix = grid;
        this.rowLength = matrix.length;
        this.columnLength = matrix[0].length;
        this.dp = new int[this.rowLength][this.columnLength];

        int ans = 0;
        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.columnLength; j++) {
                ans = (ans + longestIncreasingPath(i, j)) % mod;
            }
        }
        return ans;
    }
}