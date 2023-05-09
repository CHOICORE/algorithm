class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0)
            return new int[][]{newInterval};

        int insertionPointStart = Arrays.binarySearch(intervals, 0, len, new int[]{newInterval[0], newInterval[0]}, Comparator.comparingInt(a -> a[0]));
        insertionPointStart = Math.max(insertionPointStart, -insertionPointStart - 1);

        int insertionPointEnd = Arrays.binarySearch(intervals, 0, len, new int[]{newInterval[1] + 1, newInterval[1] + 1}, Comparator.comparingInt(a -> a[0]));
        insertionPointEnd = Math.max(insertionPointEnd, -insertionPointEnd - 1);

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i < insertionPointStart - 1 || i >= insertionPointEnd) {
                if (i == 0 && insertionPointEnd == 0) {
                    res.add(newInterval);
                }
                res.add(intervals[i]);
            } else {
                if (i == insertionPointStart - 1) {
                    if (intervals[i][1] >= newInterval[0]) {
                        newInterval[0] = intervals[i][0];
                    } else {
                        res.add(intervals[i]);
                    }
                } else if (i >= insertionPointStart) {
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                }

                if (i == Math.max(0, insertionPointEnd - 1)) {
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                    res.add(newInterval);
                }
            }
        }

        return res.toArray(new int[1][1]);
    }
}