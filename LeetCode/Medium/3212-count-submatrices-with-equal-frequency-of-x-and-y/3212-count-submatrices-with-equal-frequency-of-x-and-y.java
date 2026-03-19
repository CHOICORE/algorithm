class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] x = new int[cols];
        int[] y = new int[cols];
        int r = 0;

        for (char[] chars : grid) {
            int rx = 0, ry = 0;
            
            for (int j = 0; j < cols; j++) {
                if (chars[j] == 'X') rx++;
                else if (chars[j] == 'Y') ry++;

                x[j] += rx;
                y[j] += ry;

                if (x[j] > 0 && x[j] == y[j]) r++;
            }
        }

        return r;
    }
}