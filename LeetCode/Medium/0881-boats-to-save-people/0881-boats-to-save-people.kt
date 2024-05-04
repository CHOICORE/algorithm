class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
      val n = people.size
        if (n < 2) {
            return n
        }
        if (limit < 1) {
            return 0
        }

        Arrays.sort(people)

        var boots = 0

        var start = 0
        var end = n - 1
        while (start <= end) {

            if (people[end] + people[start] <= limit) {
                start++
                end--
            } else {
                end--
            }
            boots++
        }

        return boots
    }
}
