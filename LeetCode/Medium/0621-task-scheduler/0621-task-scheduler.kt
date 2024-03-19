class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        for (ch in tasks) {
            freq[ch.code - 'A'.code]++
        }

        val pq: PriorityQueue<Int> = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0..25) {
            if (freq[i] > 0) {
                pq.offer(freq[i])
            }
        }

        var time = 0
        while (!pq.isEmpty()) {
            var cycle = n + 1
            val store: MutableList<Int> = ArrayList()
            var taskCount = 0
            while (cycle-- > 0 && !pq.isEmpty()) {
                val currentFreq = pq.poll()
                if (currentFreq > 1) {
                    store.add(currentFreq - 1)
                }
                taskCount++
            }
            store.forEach(Consumer { e: Int -> pq.offer(e) })
            time += (if (pq.isEmpty()) taskCount else n + 1)
        }
        return time
    }
}