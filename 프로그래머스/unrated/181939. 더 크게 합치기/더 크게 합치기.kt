class Solution {
    fun solution(a: Int, b: Int): Int = "$a$b".toInt().coerceAtLeast("$b$a".toInt())
}