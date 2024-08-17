class Solution {
    public long maxPoints(int[][] points) {
        int columns = points[0].length;
        long[] current = new long[columns], previousRow = new long[columns];
        for (int[] row : points) {
            long runningMax = 0;

            for (int col = 0; col < columns; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                current[col] = runningMax;
            }

            runningMax = 0;
            for (int col = columns - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                current[col] = Math.max(current[col], runningMax) +
                        row[col];
            }

            previousRow = current;
        }

        long maxPoints = 0;
        for (int col = 0; col < columns; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
