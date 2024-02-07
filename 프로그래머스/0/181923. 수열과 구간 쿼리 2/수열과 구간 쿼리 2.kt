import kotlin.math.min

internal class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val s = query[0]
            val e = query[1]
            val k = query[2]

            answer[i] = -1
            for (j in s until e + 1) {
                val digit = arr[j]
                if (k < digit) {
                    if (answer[i] == -1) {
                        answer[i] = digit
                    } else {
                        answer[i] = min(answer[i], digit)
                    }
                }
            }
        }

        return answer
    }
}