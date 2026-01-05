class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long t = 0;
        int abs = Integer.MAX_VALUE;
        int negatives = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                t += Math.abs(val);
                if (val < 0) {
                    negatives++;
                }
                abs = Math.min(abs, Math.abs(val));
            }
        }

        if (negatives % 2 != 0) {
            t -= 2L * abs;
        }

        return t;
    }
}