class Solution {
    public int climbStairs(int n) {
        int[] m = new int[10_000];
        m[1] = 1;
        m[2] = 2;

        for (int i = 3; i <= n; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }

        return m[n];
    }
}