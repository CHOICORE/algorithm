class Solution {
    fun minimumReplacement(nums: IntArray): Long {
        var answer = 0L
        val n = nums.size

        for (i in n - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                continue
            }

            val numElements = (nums[i] + nums[i + 1] - 1) / nums[i + 1].toLong()

            answer += numElements - 1

            nums[i] /= numElements.toInt()
        }

        return answer
    }
}