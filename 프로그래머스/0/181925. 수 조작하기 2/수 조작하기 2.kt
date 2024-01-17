class Solution {
    fun solution(numLog: IntArray): String {
        val answer = StringBuilder()

        for (i: Int in 1 until numLog.size) {
            val diff: Int = numLog[i] - numLog[i - 1]
            when (diff) {
                1 -> answer.append("w")
                -1 -> answer.append("s")
                10 -> answer.append("d")
                -10 -> answer.append("a")
            }
        }

        return answer.toString()
    }
}