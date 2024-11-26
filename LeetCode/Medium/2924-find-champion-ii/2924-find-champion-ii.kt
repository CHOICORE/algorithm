class Solution {
    fun findChampion(
        n: Int,
        edges: Array<IntArray>,
    ): Int {
        val degree = IntArray(n)

        for (edge in edges) {
            degree[edge[1]]++
        }

        var champ = -1
        var champCount = 0

        for (i in 0 until n) {
            if (degree[i] == 0) {
                champCount++
                champ = i
            }
        }

        return if (champCount > 1) -1 else champ
    }
}
