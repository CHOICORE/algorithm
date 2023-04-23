class Solution {
    public int numberOfArrays(String s, int k) {
        long[] dp = new long[10];
        int c = 9;
        int d = 1_000_000_007;
        int sz = s.length();
        for (int i = sz - 1; i >= 0; i--) {
            long cur = 0;
            long cr = 0;
            for (int j = i; j < sz; j++) {
                cur = cur * 10 + s.charAt(j) - '0';
                if (cur > k || (cur == 0))
                    break;
                if (j == sz - 1)
                    cr += 1 % d;
                else
                    cr += dp[(j - i + c + 1) % 10] % d;
            }
            dp[c] = cr % d;
            c--;
            c = c == -1 ? 9 : c;
        }
        return (int) dp[(c + 1) % 10] % d;
    }
}