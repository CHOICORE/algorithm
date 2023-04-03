class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int row = 0, col = i;
            while (row < m) {
                if (grid[row][col] == 1 && col + 1 < n && grid[row][col+1] == 1) {
                    col++;
                    row++;
                } else if (grid[row][col] == -1 && col > 0 && grid[row][col-1] == -1) {
                    col--;
                    row++;
                } else {
                    answer[i] = -1;
                    break;
                }
            }
            if (row == m) {
                answer[i] = col;
            }
        }
        return answer;
    }
}
