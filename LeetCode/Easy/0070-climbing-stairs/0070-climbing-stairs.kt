class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1
        var last = 1
        var beforeLast = 2

        for (i in 3..n) {
            val tmp = last + beforeLast
            last = beforeLast
            beforeLast = tmp
        }

        return beforeLast
    }
}
