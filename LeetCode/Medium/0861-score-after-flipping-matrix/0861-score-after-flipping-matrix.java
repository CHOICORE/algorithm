class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        for (int j = 1; j < n; j++) {
            int countZero = 0;
            for (int[] ints : grid) {
                if (ints[j] == 0) {
                    countZero++;
                }
            }
            if (countZero > m - countZero) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        int score = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                int columnScore = ints[j] << (n - j - 1);
                score += columnScore;
            }
        }
        
        return score;
    }
}