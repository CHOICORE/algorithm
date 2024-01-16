class Solution {
    fun solution(n: Int, control: String): Int {
        return control.fold(n) { acc: Int, c: Char ->
            acc + when (c) {
                'w' -> 1
                's' -> -1
                'd' -> 10
                'a' -> -10
                else -> throw IllegalArgumentException("Invalid control")
            }
        }
    }
}