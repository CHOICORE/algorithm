class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int r = grid.length - 1;
        int c = 0;
        int c_length = grid[r].length;

        while (r >= 0 && c < c_length) {

            if (grid[r][c] < 0) {
                r--;
                count = count + c_length - c;
            } else {
                c++;
            }
        }
        return count;
    }
}