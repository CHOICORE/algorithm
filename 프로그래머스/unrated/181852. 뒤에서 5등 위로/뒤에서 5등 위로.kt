class Solution {
    fun solution(num_list: IntArray): IntArray = num_list.sorted().drop(5).toIntArray()
}