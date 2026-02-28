class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long r = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) bits++;
            r = ((r << bits) | i) % MOD;
        }
        return (int) r;
    }
}