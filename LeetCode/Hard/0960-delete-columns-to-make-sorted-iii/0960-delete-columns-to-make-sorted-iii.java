class Solution {
    public int minDeletionSize(String[] strs) {
        int l = strs[0].length();
        int[] dp = new int[l];
        Arrays.fill(dp, 1);
        for (int i = l - 2; i >= 0; --i)
            search:for (int j = i + 1; j < l; ++j) {
                for (String row : strs)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

        int s = 0;
        for (int x : dp)
            s = Math.max(s, x);
        return l - s;
    }
}