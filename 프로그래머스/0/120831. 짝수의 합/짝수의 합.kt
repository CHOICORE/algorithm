class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var sum = n
        
        while (sum > 0) {
            if (sum % 2 == 0) {
                answer += sum
            }
            sum--
        }

        return answer
    }
}