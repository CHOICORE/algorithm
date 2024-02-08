class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1)
        Arrays.fill(dp, Int.MAX_VALUE)
        dp[0] = 0
        for (i in 1..n) {
            var min = Int.MAX_VALUE
            var j = 1
            while (j * j <= i) {
                min = min(min.toDouble(), (dp[i - j * j] + 1).toDouble()).toInt()
                ++j
            }
            dp[i] = min
        }
        return dp[n]
    }
}
