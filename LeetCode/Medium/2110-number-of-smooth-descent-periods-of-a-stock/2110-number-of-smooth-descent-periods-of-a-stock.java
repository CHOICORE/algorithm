class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long r = 1;
        int p = 1;

        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                ++p;
            } else {
                p = 1;
            }
            r += p;
        }
        return r;
    }
}