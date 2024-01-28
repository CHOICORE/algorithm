class Solution {
    static final int BASE_SUM = -10_000_000;
    static byte[] map = new byte[20_000_001];

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rowLastIdx = matrix.length - 1;
        int colLastIdx = matrix[0].length - 1;
        int result = 0;

        int[][] colSums;
        if (rowLastIdx <= colLastIdx) {                 // Height <= width
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = colSums[row][col] = sum + matrix[row][col];
            }
        } else {
            int temp = colLastIdx;
            colLastIdx = rowLastIdx;
            rowLastIdx = temp;
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int[] curSumRow = colSums[row];
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = curSumRow[col] = sum + matrix[col][row];
            }
        }

        int[] curRowSums = new int[rowLastIdx + 2];
        
        for (int startCol = colLastIdx; startCol >= 0; startCol--) {
            for (int colWidth = colLastIdx - startCol + 1; colWidth > 0; colWidth--) {
                int sum = -BASE_SUM;
                map[target - BASE_SUM] = 1;
                curRowSums[rowLastIdx + 1] = target - BASE_SUM;
                for (int row = rowLastIdx; row >= 0; row--) {
                    sum += colSums[row][startCol] - colSums[row][startCol + colWidth];
                    result += map[sum];
                    map[sum + target]++;
                    curRowSums[row] = sum + target;
                }
                for (int row = rowLastIdx + 1; row >= 0; row--)
                    map[curRowSums[row]] = 0;
            }
        }

        return result;
    }
}