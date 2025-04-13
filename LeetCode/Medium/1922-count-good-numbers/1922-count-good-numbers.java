class Solution {
    long mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        return (int) ((quick(5, (n + 1) / 2) * quick(4, n / 2)) % mod);
    }
    
    public long quick(int x, long y) {
        long result = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y /= 2;
        }

        return result;
    }
}