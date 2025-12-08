class Solution {
    public int countTriples(int n) {
        int r = 0;
        for (int i = 1; i <= n; ++i) {
            for (int b = 1; b <= n; ++b) {
                int c = (int) Math.sqrt(i * i + b * b + 1.0);
                if (c <= n && c * c == i * i + b * b) {
                    ++r;
                }
            }
        }
        return r;
    }
}