class Solution {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }

        int[] range = new int[max - min + 1];
        for (int[] interval : intervals) {
            range[interval[0] - min] = Math.max(interval[1] - min, range[interval[0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[]{start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[]{start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }
}