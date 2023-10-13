class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in 2 until cost.size) {
            cost[i] += min(cost[i - 1], cost[i - 2])
        }
        return min(cost[cost.size - 1], cost[cost.size - 2])
    }
}