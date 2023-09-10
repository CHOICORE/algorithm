class Solution {
    private static final int MOD = 1_000_000_007;

    public int countOrders(int n) {
        long count = 1;
        for (int i = 2; i <= n; i++) {
            count = (count * (2L * i - 1) * i) % MOD;
        }
        return (int) count;
    }
}