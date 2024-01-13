class Solution {
    fun solution(num_list: IntArray): Int {
        var odd = ""
        var even = ""

        for (i in num_list) {
            if (i % 2 == 0) {
                even += "$i"
            } else {
                odd += "$i"
            }
        }
        
        return even.toInt() + odd.toInt()
    }
}