class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { (i: Int, j: Int) ->
            val temp: Int = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        return arr
    }
}