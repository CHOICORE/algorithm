class Solution {
    fun solution(num_list: IntArray): IntArray = num_list.toMutableList().apply {
        if (last() > get(size - 2)) add(last() - get(size - 2))
        else add(last() * 2)
    }.toIntArray()
}