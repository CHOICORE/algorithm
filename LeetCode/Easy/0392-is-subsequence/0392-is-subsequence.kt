class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        val n: Int = t.length
        val m: Int = s.length
        val sCharArray: CharArray = s.toCharArray()
        val tCharArray: CharArray = t.toCharArray()
        if (m < 1) return true
        while (i < n) {
            if (tCharArray[i] == sCharArray[j]) {
                j++
            }
            i++
            if (j == m) return true
        }
        return false
    }
}
