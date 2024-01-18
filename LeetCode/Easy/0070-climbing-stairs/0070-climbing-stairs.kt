class Solution {
    fun climbStairs(n: Int): Int {
        val m = IntArray(10_000)
        m[1] = 1
        m[2] = 2

        for (i in 3..n) {
            m[i] = m[i - 1] + m[i - 2]
        }

        return m[n]
    }
}