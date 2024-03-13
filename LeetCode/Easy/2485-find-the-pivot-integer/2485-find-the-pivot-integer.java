class Solution {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            int l = 0;
            int r = 0;

            for (int j = 1; j <= i; j++) {
                l += j;
            }

            for (int k = i; k <= n; k++) {
                r += k;
            }

            if (l == r) {
                return i;
            }
        }

        return -1;
    }
}