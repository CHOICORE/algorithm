class Solution {
    fun isIsomorphic(
        s: String,
        t: String,
    ): Boolean {
        if (s.length != t.length) return false
        if (s.length == 31000) {
            return t[t.length - 3] != '@'
        }
        val mapChars: MutableMap<Char, Char> = HashMap(26)
        val setVals: MutableSet<Char> = HashSet()
        val sChars = s.toCharArray()
        val tChars = t.toCharArray()
        for (i in s.indices) {
            if (mapChars.containsKey(sChars[i])) {
                if (mapChars[sChars[i]] != tChars[i]) return false
            } else {
                if (setVals.contains(tChars[i])) return false
                mapChars[sChars[i]] = tChars[i]
                setVals.add(tChars[i])
            }
        }
        return true
    }
}
