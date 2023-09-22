class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        } else if (t.isEmpty()) {
            return false
        }
        var sIndex = 0
        var tIndex = 0
        while (tIndex < t.length && sIndex < s.length) {
            if (s[sIndex] == t[tIndex++]) {
                sIndex++
            }
        }
        return sIndex == s.length
    }
}