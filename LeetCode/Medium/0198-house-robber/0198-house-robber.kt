class Solution {
    fun rob(nums: IntArray): Int {
        var last = 0
        var prev = 0
        var current = 0
        for (index in nums.indices) {
            current = (prev + nums[index]).coerceAtLeast(last)
            prev = last
            last = current
        }
        return last;
    }
}