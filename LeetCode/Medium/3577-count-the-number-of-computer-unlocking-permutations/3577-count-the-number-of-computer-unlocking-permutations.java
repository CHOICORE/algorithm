class Solution {
    static final int MOD = (int) (1e9 + 7);

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int r = 1;
        for (int i = 2; i < n; i++) {
            r = (int) (((long) r * i) % MOD);
        }
        return r;
    }
}