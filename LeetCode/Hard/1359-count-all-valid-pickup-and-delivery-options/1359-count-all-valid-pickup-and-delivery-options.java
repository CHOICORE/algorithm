class Solution {
    public int countOrders(int n) {
        long mod = (long) (1e9 + 7);
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i * (2L * i - 1)) % mod;
        }
        return (int) (res);
    }
}