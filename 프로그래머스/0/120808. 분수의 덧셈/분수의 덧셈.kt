class Solution {
    fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        var answer: IntArray = intArrayOf()

        val number3 = numer1 * denom2 + numer2 * denom1
        val denon3 = denom1 * denom2

        return intArrayOf(number3 / gcd(number3, denon3), denon3 / gcd(number3, denon3))
    }
}
