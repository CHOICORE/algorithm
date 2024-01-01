class Solution {
    fun solution(nums: IntArray, n: Int): IntArray {
        return (nums.indices step n).map { nums[it] }.toIntArray()
    }
}