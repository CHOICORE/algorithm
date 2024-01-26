class Solution {
    fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

    fun solution(denom1: Int, num1: Int, denom2: Int, num2: Int): IntArray {
        var answer: IntArray = intArrayOf()

        val denom = denom1 * num2 + denom2 * num1
        val num = num1 * num2

        return intArrayOf(denom / gcd(denom, num), num / gcd(denom, num))
    }
}
