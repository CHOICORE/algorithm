class Solution {
    fun solution(a: Int, b: Int): Int = "$a$b".toInt().coerceAtLeast(2 * a * b)
}