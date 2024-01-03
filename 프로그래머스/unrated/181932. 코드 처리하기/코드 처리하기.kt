class Solution {
    fun solution(code: String): String {
        var mode = 0
        return code.filterIndexed { i: Int, c: Char ->
            if (c == '1') mode = (mode + 1) % 2
            c != '1' && mode == i % 2
        }.ifEmpty { "EMPTY" }
    }
}