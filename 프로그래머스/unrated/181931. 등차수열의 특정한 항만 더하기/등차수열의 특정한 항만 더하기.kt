class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int =
        included.mapIndexed { index: Int, b: Boolean -> if (b) a + d * index else 0 }.sum()
}
