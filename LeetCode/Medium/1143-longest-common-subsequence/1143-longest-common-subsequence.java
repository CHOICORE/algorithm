class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2))
            return text1.length();
        char[] tb1 = text1.toCharArray();
        char[] tb2 = text2.toCharArray();

        if (tb1.length > tb2.length) {
            return calc(tb2, tb1);
        } else {
            return calc(tb1, tb2);
        }
    }

    private int calc(final char[] tb1, final char[] tb2) {
        int[] dp = new int[tb2.length + 1];
        int i = 0;
        while (i < tb1.length) {
            int pc = 0, prc;
            for (int j = 0; j < tb2.length; j++) {
                prc = pc;
                pc = dp[j + 1];
                if (tb1[i] == tb2[j]) {
                    dp[j + 1] = prc + 1;
                } else {
                    dp[j + 1] = Math.max(pc, dp[j]);
                }
            }
            i++;
        }

        return dp[tb2.length];
    }
}