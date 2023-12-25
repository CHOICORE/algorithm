class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        return when (ineq + eq) {
            ">=" -> return if (n >= m) 1 else 0
            "<=" -> return if (n <= m) 1 else 0
            "<!" -> return if (n < m) 1 else 0
            ">!" -> return if (n > m) 1 else 0
            else -> 0
        }
    }
}