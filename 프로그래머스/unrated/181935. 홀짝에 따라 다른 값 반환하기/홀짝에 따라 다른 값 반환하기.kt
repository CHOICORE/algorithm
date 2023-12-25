class Solution {
    fun solution(n: Int): Int {
        return if (n % 2 == 0) {
            (n downTo 1 step 2).sumOf { it * it }
        } else {
            (n downTo 1 step 2).sum()
        }
    }
}