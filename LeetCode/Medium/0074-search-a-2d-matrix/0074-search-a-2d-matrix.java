class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (final int[] ints : matrix) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}