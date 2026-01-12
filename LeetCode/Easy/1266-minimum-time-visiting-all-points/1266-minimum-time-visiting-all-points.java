class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int r = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int n = points[i + 1][0];
            int m = points[i + 1][1];
            r += Math.max(Math.abs(n - x), Math.abs(m - y));
        }

        return r;
    }
}