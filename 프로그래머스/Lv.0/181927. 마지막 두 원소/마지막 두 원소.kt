class Solution {
    fun solution(num_list: IntArray): IntArray {
        val len = num_list.size

        val answer = num_list.copyOf(len + 1)

        val last = num_list[len - 1]
        val beforeLast = num_list[len - 2]

        if (last > beforeLast) {
            answer[len] = last - beforeLast
        } else {
            answer[len] = last * 2
        }

        return answer
    }
}