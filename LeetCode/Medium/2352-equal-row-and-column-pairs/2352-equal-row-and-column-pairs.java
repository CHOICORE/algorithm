class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;
        long[] rowSums = new long[n];
        long[] colSums = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum * 10 + grid[i][j];
            }
            rowSums[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum * 10 + grid[j][i];
            }
            colSums[i] = sum;
        }

        int count = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSums[i] == colSums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}