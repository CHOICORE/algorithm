class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer = 0
        for (i in included.indices) {
            if (included[i]) {
                answer += a + d * i
            }
        }
        return answer
    }
}