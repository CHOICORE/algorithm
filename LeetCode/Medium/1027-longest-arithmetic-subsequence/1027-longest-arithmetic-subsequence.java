class Solution {
    public int longestArithSeqLength(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int diff = max - min, ans = 0;
        for (int d = -diff; d <= diff; d++) {
            int[] dp = new int[max + 1];
            for (int num : nums) {
                int prev = num - d;
                dp[num] = prev >= min && prev <= max ? dp[prev] + 1 : 1;
                ans = Math.max(ans, dp[num]);
            }
        }
        return ans;
    }
}