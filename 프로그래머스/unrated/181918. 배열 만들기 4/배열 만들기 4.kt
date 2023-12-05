class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: IntArray = intArrayOf()

        var i: Int = 0
        while (i < arr.size) {
            if (stk.isEmpty() || stk.last() < arr[i]) {
                stk += arr[i++]
            } else if (stk.last() >= arr[i]) {
                stk = stk.dropLast(1).toIntArray()
            }
        }

        return stk
    }
}