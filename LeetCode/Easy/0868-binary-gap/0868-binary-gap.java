class Solution {
    public int binaryGap(int n) {
        int[] a = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((n >> i) & 1) != 0)
                a[t++] = i;

        int r = 0;
        for (int i = 0; i < t - 1; ++i) {
            r = Math.max(r, a[i + 1] - a[i]);
        }
        return r;
    }
}