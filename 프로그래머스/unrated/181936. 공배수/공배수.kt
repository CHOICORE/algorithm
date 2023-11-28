class Solution {
    fun solution(number: Int, n: Int, m: Int): Int = if ((number % n) + (number % m) == 0) 1 else 0
}