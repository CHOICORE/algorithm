class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sCount = IntArray(256)
        val tCount = IntArray(256)

        for (i in s.indices) {
            if (sCount[s[i].code] != tCount[t[i].code]) return false
            sCount[s[i].code] = i + 1
            tCount[t[i].code] = i + 1
        }

        return true
    }
}
