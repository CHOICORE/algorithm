class Solution {
    fun longestPalindrome(s: String): Int {
        val counts = IntArray(128) { 0 }
        for (char in s) {
            counts[char.code] = counts[char.code] + 1
        }
        var odd = 0
        var max = 0

        for (count in counts) {
            if (count % 2 == 0) {
                max += count
            } else {
                max += count - 1
                odd = 1
            }
        }

        return (max + odd)
    }
}