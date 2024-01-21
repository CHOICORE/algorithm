class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n < 2) return nums[0]

        val dp = IntArray(n)
        dp[0] = nums[0]
        dp[1] = max(nums[0].toDouble(), nums[1].toDouble()).toInt()
        for (i in 2 until n) {
            dp[i] = max(dp[i - 1].toDouble(), (dp[i - 2] + nums[i]).toDouble()).toInt()
        }

        return dp[n - 1]
    }
}