class Solution {
    public int climbStairs(int n) {

        // DP(Dynamic Programming) 배열 초기화
        int[] dp = new int[n+1]; // i번째 계단까지 오는 데 필요한 경우의 수 초기화      
        dp[0] = 1; // 0번째 계단까지 오는 경우의 수 (아무것도 안 한 경우)
        dp[1] = 1; // 1번째 계단까지 오는 경우의 수 (한 칸 올라간 경우)

        // dp 배열 채우기
        for (int i = 2; i <= n; i++) {
            // i번째 계단까지 오는 경우의 수는 (i-1)번째 계단에서 1칸 오른 경우의 수와 (i-2)번째 계단에서 2칸 오른 경우의 수를 더한 것과 같다.
            dp[i] = dp[i-1] + dp[i-2]; 
        }

        return dp[n]; // n번째 계단까지 오는 경우의 수 반환
    }
}
