class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        val set = intArrayOf(a, b, c).toSet()
        return when (set.size) {
            3 -> a + b + c
            2 -> (a + b + c) * (a * a + b * b + c * c)
            1 -> (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
            else -> -1
        }
    }
}