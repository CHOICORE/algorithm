class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val resultCost = IntArray(cost.size + 1) { 0 }

        for (i in cost.indices) {
            resultCost[i] = cost[i]
        }
        if (cost.size == 1) {
            return cost[0]
        }

        for (i in cost.size - 2 downTo 0) {
            resultCost[i] = (resultCost[i] + resultCost[i + 1]).coerceAtMost(resultCost[i] + resultCost[i + 2])
        }

        return resultCost[0].coerceAtMost(resultCost[1])
    }
}