class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        
        // 첫 번째 인덱스 초기화
        dp[0] = cost[0]; 
        // 두 번째 인덱스 초기화
        dp[1] = cost[1]; 
        
        for (int i = 2; i < n; i++) {
            // i번째까지 도달하는 데 필요한 최소 비용
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        
        // 마지막 계단 또는 마지막에서 두 번째 계단 중 최소 비용 리턴
        return Math.min(dp[n-1], dp[n-2]);
    }
}
