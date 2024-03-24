class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val taken = BooleanArray(nums.size)
        for (num in nums) {
            if (taken[num]) {
                return num
            }
            taken[num] = true
        }
        return 0
    }
}