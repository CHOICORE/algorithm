class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { 0 }
        dp[1] = 1

        for (i in 2..n) {
            var min = i
            var j = 1
            while (j * j <= i) {
                min = min(min, dp[i - j * j])
                j++
            }
            dp[i] = min + 1
        }
        return dp[n]
    }
}
