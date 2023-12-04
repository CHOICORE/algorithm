class Solution {
    fun solution(num_list: IntArray): IntArray {
        return num_list.sorted().slice(5..num_list.size - 1).toIntArray()
    }
}