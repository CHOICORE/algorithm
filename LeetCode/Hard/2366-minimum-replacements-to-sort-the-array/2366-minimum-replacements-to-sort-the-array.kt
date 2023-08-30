class Solution {
    fun minimumReplacement(nums: IntArray): Long {
        var last = nums.last()
        var replace = 0L
        ((nums.lastIndex - 1) downTo 0).forEach { numsIndex ->
            val num = nums[numsIndex]
            if (last > num) {
                last = num
                return@forEach
            }
            val divideCount = num / last
            if (num % last == 0) {
                replace += (divideCount.toLong() - 1)
            } else {

                last = num / (divideCount + 1)
                replace += divideCount.toLong()
            }
        }
        return replace
    }
}