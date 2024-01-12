class Solution {
    fun solution(num_list: IntArray): Int {
        var multiply = 1
        var sum = 0

        for (i in num_list) {
            multiply *= i
            sum += i
        }
        sum *= sum

        return if ((multiply < sum)) 1 else 0
    }
}