class Solution {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double r = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; ++j)
                for (int k = j + 1; k < N; ++k)
                    r = Math.max(r, area(points[i], points[j], points[k]));
        return r;
    }

    public double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0] * q[1] + q[0] * r[1] + r[0] * p[1] - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }
}