class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] reverse = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                reverse[j][i] = grid[i][j];
            }
        }
        int ans = 0;
        for (int[] row : grid) {
            for (int[] col : reverse) {
                if (Arrays.equals(row, col)) ans++;
            }
        }
        return ans;
    }
}