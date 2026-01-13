class Solution {
    public double separateSquares(int[][] squares) {
        long totalArea = 0;
        List<int[]> events = new ArrayList<>();

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            totalArea += (long) l * l;
            events.add(new int[]{y, l, 1});
            events.add(new int[]{y + l, l, -1});
        }

        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        double coveredWidth = 0;
        double currArea = 0;
        double prevHeight = 0;

        for (int[] event : events) {
            int y = event[0];
            int l = event[1];
            int delta = event[2];

            int diff = y - (int) prevHeight;
            double area = coveredWidth * diff;
            if (2L * (currArea + area) >= totalArea) {
                return (
                        prevHeight +
                                (totalArea - 2.0 * currArea) / (2.0 * coveredWidth)
                );
            }
            coveredWidth += delta * l;
            currArea += area;
            prevHeight = y;
        }

        return 0.0;
    }
}