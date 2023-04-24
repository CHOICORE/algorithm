class Solution {
    public int minInsertions(String s) {
        int lps = dyP(s);
        return s.length() - lps;
    }

    public int dyP(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int max = 0;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for (int i = j - 1; i >= 0; i--) {
                int len = dp[i];
                if (c[i] == c[j]) {
                    dp[i] = 2 + max;
                }
                max = Math.max(max, len);
            }
        }
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}