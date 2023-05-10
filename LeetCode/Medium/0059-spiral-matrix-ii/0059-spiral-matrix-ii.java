
class Solution {
    public int[][] generateMatrix(int n) {
        int element = 1;
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = element;
                element++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = element;
                element++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = element;
                    element++;
                }
            }
            bottom--;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = element;
                    element++;
                }
            }
            left++;
        }
        return matrix;
    }
}