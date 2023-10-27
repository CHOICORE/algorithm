class Solution {
    fun longestPalindrome(s: String): String {
        val sPrime = StringBuilder("#")
        for (c in s.toCharArray()) {
            sPrime.append(c).append("#")
        }
        val n = sPrime.length
        val palindromeRadii = IntArray(n)
        var center = 0
        var radius = 0
        for (i in 0 until n) {
            val mirror = 2 * center - i
            if (i < radius) {
                palindromeRadii[i] =
                    min((radius - i).toDouble(), palindromeRadii[mirror].toDouble()).toInt()
            }
            while (i + 1 + palindromeRadii[i] < n
                && i - 1 - palindromeRadii[i] >= 0
                && sPrime[i + 1 + palindromeRadii[i]] == sPrime[i - 1 - palindromeRadii[i]]
            ) {
                palindromeRadii[i]++
            }
            if (i + palindromeRadii[i] > radius) {
                center = i
                radius = i + palindromeRadii[i]
            }
        }
        var maxLength = 0
        var centerIndex = 0
        for (i in 0 until n) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i]
                centerIndex = i
            }
        }
        val startIndex = (centerIndex - maxLength) / 2
        return s.substring(startIndex, startIndex + maxLength)
    }
}