class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freqs = IntArray(26)
        for (ch in tasks) {
            freqs[ch - 'A']++
        }

        Arrays.sort(freqs)
        var idles = (freqs[25] - 1) * n
        for (i in 24 downTo 0) {
            if (idles <= 0) {
                break
            }

            idles -= Math.min(freqs[i], freqs[25] - 1)
        }
        idles = Math.max(0, idles)

        return tasks.size + idles
    }
}
