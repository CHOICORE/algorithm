class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int left = 0;
        int right = len - 1;
        while (left < len && newInterval[0] > intervals[left][1]) {
            left++;
        }
        while (right >= 0 && newInterval[1] < intervals[right][0]) {
            right--;
        }
        int[][] res = new int[left + len - right][2];
        for (int i = 0; i < left; i++) {
            res[i] = Arrays.copyOf(intervals[i], intervals[i].length);
        }
        res[left][0] = Math.min(newInterval[0], left == len ? newInterval[0] : intervals[left][0]);
        res[left][1] = Math.max(newInterval[1], right == -1 ? newInterval[1] : intervals[right][1]);
        for (int i = left + 1, j = right + 1; j < len; i++, j++) {
            res[i] = intervals[j];
        }
        return res;
    }
}
