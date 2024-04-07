class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        
        dp[n][0] = true;

        for (int index = n - 1; index >= 0; index--) {
            for (int openBracket = 0; openBracket < n; openBracket++) {
                boolean isValid = false;
                
                if (s.charAt(index) == '*') {
                    isValid |= dp[index + 1][openBracket + 1];
                    if (openBracket > 0) {
                        isValid |= dp[index + 1][openBracket - 1];
                    }
                    isValid |= dp[index + 1][openBracket];
                } else {
                    if (s.charAt(index) == '(') {
                        isValid |= dp[index + 1][openBracket + 1];
                    } else if (openBracket > 0) {
                        isValid |= dp[index + 1][openBracket - 1];
                    }
                }
                dp[index][openBracket] = isValid;
            }
        }

        return dp[0][0];
    }
}