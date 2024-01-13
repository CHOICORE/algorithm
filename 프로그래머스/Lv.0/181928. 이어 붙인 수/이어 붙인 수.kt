class Solution {
    fun solution(num_list: IntArray): Int {
        var even = 0
        var odd = 0

        for (num in num_list) {
            if (num % 2 == 0) {
                even *= 10
                even += num
            } else {
                odd *= 10
                odd += num
            }
        }

        return even + odd
    }
}