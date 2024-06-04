class Solution {
    fun longestPalindrome(s: String): Int {
        val array = IntArray(58)
        var count = 0
        var odd = 0

        for (each in s.toCharArray()) {
            array[each.code - 'A'.code]++
        }

        for (each in array) {
            if (each % 2 == 0 && each != 0) {
                count += each
            } else if (each % 2 == 1 && each != 1) {
                count += each - 1
                odd = 1
            } else if (each == 1) {
                odd = 1
            }
        }

        return count + odd
    }
}