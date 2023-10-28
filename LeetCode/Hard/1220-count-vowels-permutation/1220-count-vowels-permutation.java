class Solution {
    int MOD = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long[][] mat = new long[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0}
        };

        long[][] ans = new long[][]{{1}, {1}, {1}, {1}, {1}};
        int x = n - 1;

        while (x > 0) {
            if ((x & 1) == 1) ans = multiply(mat, ans);
            mat = multiply(mat, mat);
            x >>= 1;
        }
        long sum = 0;
        for (int i = 0; i < 5; i++) sum += ans[i][0];
        return (int) (sum % MOD);
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }

        return ans;
    }
}