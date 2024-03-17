class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var start = newInterval[0]
        var end = newInterval[1]
        var i = 0
        val ans = mutableListOf<IntArray>()
        while (i < intervals.size && intervals[i][1] < start) {
            ans += intervals[i++]
        }
        while (i < intervals.size) {
            if (intervals[i][0] <= end) {
                start = intervals[i][0].coerceAtMost(start)
                end = intervals[i][1].coerceAtLeast(end)
                i++
            } else {
                ans += intArrayOf(start, end)
                start = intervals[i][0]
                end = intervals[i][1]
                i++
            }
        }
        ans += intArrayOf(start, end)
        return ans.toTypedArray()
    }
}