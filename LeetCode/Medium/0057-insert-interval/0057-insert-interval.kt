class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result: MutableList<IntArray> = java.util.ArrayList<IntArray>()
        var i = 0

        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }

        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)

        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }

        val arr = Array(result.size) { IntArray(2) }
        for (j in result.indices) {
            arr[j] = result[j]
        }

        return arr
    }
}