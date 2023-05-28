class Solution {

    public int solve(int cuts[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int temp = cuts[j + 1] - cuts[i - 1] + solve(cuts, i, k - 1, dp) + solve(cuts, k + 1, j, dp);
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;

    }


    public int minCost(int n, int[] cuts) {
        int c[] = new int[cuts.length + 2];
        c[0] = 0;
        c[c.length - 1] = n;
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, c, 1, c.length - 1 - 1);
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return solve(c, 1, c.length - 2, dp);
    }
}