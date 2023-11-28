class Solution {
    fun solution(a: Int, b: Int): Int {
        val strA: String = a.toString()
        val strB: String = b.toString()
        val sumA: String = strA + strB
        val sumB: String = strB + strA
        return sumA.toInt().coerceAtLeast(sumB.toInt())
    }
}