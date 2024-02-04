class Solution {
    fun minWindow(
        s: String,
        t: String,
    ): String {
        val map = IntArray(123)
        var left = 0
        var right = 0
        var count: Int = t.length
        var tmp: Int = Int.MAX_VALUE
        var start = 0

        for (c: Char in t.toCharArray()) map[c.code]++

        val ch: CharArray = s.toCharArray()
        while (right < s.length) {
            if (map[ch[right++].code]-- > 0) count--

            while (count == 0) {
                if ((right - left) < tmp) tmp = right - (left.also { start = it })
                if (map[ch[left++].code]++ == 0) count++
            }
        }

        return if (tmp == Int.MAX_VALUE) "" else s.substring(start, start + tmp)
    }
}
