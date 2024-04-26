class Solution {
    public int minFallingPathSum(int[][] grid) {
        int nextMin1C = -1;
        int nextMin2C = -1;

        int nextMin1 = -1;
        int nextMin2 = -1;

        for (int col = 0; col < grid.length; col++) {
            if (nextMin1 == -1 || grid[grid.length - 1][col] <= nextMin1) {
                nextMin2 = nextMin1;
                nextMin2C = nextMin1C;
                nextMin1 = grid[grid.length - 1][col];
                nextMin1C = col;
            } else if (nextMin2 == -1 || grid[grid.length - 1][col] <= nextMin2) {
                nextMin2 = grid[grid.length - 1][col];
                nextMin2C = col;
            }
        }

        for (int row = grid.length - 2; row >= 0; row--) {
            int min1C = -1;
            int min2C = -1;

            int min1 = -1;
            int min2 = -1;

            for (int col = 0; col < grid.length; col++) {
                int value;
                if (col != nextMin1C) {
                    value = grid[row][col] + nextMin1;
                } else {
                    value = grid[row][col] + nextMin2;
                }

                if (min1 == -1 || value <= min1) {
                    min2 = min1;
                    min2C = min1C;
                    min1 = value;
                    min1C = col;
                } else if (min2 == -1 || value <= min2) {
                    min2 = value;
                    min2C = col;
                }
            }

            nextMin1C = min1C;
            nextMin1 = min1;
            nextMin2 = min2;
        }

        return nextMin1;
    }
}