class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val buckets = IntArray(limit + 1)
        for (weight in people) {
            buckets[weight]++
        }

        var start = 0
        var end = buckets.size - 1
        var boats = 0
        while (start <= end) {
            while (start <= end && buckets[start] <= 0) start++
            while (start <= end && buckets[end] <= 0) end--

            if (buckets[start] <= 0 && buckets[end] <= 0) break

            boats++
            if (start + end <= limit) {
                buckets[start]--
            }
            buckets[end]--
        }
        return boats
    }
}
