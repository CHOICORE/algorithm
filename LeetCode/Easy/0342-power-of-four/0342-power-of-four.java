class Solution {
    public boolean isPowerOfFour(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            int cnt = 0;
            while (n > 1) {
                cnt++;
                n >>= 1;
            }
            return cnt % 2 == 0;
        }
        return false;
    }
}