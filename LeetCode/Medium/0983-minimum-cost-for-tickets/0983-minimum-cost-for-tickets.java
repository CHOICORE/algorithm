class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp 배열 초기화
        int[] dp = new int[366];
        int dayIndex = 0;
        for (int i = 1; i <= 365; i++) {
            if (dayIndex == days.length) {
                break;
            }
            if (i == days[dayIndex]) {
                int dayAgoCost = dp[Math.max(0, i-1)] + costs[0];
                int weekCost = dp[Math.max(0, i-7)] + costs[1];
                int monthAgoCost = dp[Math.max(0, i-30)] + costs[2];
                dp[i] = Math.min(dayAgoCost, Math.min(weekCost, monthAgoCost));
                dayIndex++;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[days[days.length-1]];
    }
}
