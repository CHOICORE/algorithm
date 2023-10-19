class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        return check(s) == check(t)
    }

    private fun check(s: String): String {
        val sb = StringBuilder()
        s.forEach { it ->
            if (it != '#') {
                sb.append(it)
            } else {
                sb.let {
                    it.setLength(if (it.isNotEmpty()) it.length - 1 else 0)
                }
            }
        }
        return sb.toString()
    }
}