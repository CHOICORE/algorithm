class Solution {
    public int[] sumZero(int n) {
        int[] r = new int[n];
        int c = 0;
        for (int i = 1; i <= n / 2; ++i) {
            r[c++] = i;
            r[c++] = -i;
        }
        if (n % 2 == 1) {
            r[c] = 0;
        }
        return r;
    }
}