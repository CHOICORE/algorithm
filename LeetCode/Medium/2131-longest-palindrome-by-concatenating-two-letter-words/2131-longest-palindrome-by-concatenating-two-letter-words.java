class Solution {
    public int longestPalindrome(String[] words) {
        int[][] dp = new int[26][26];
        boolean odd = false;
        int ans = 0;

        for (String s : words) {
            dp[s.charAt(0) - 'a'][s.charAt(1) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i][j] > 0) {
                    if (i == j) {
                        if (dp[i][j] % 2 != 0) {
                            odd = true;
                            dp[i][j]--;
                        }
                        ans += dp[i][j] * 2;
                    } else {
                        int minCount = Math.min(dp[i][j], dp[j][i]);
                        if (minCount >= 1) {
                            ans += 4 * minCount;
                            dp[i][j] -= minCount;
                            dp[j][i] -= minCount;
                        }
                    }
                }
            }
        }
        return odd ? ans + 2 : ans;
    }
}