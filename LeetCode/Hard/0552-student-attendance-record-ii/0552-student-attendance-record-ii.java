class Solution {
    private final static int MOD = (int) 1e9 + 7;
    private int[][][] memo;

    public int checkRecord(int n) {
        memo = new int[n + 1][2][3];
        for (int[][] array2D : memo) {
            for (int[] array1D : array2D) {
                Arrays.fill(array1D, -1);
            }
        }
        return eligibleCombinations(n, 0, 0);
    }

    private int eligibleCombinations(int n, int totalAbsences, int consecutiveLates) {
        if (totalAbsences >= 2 || consecutiveLates >= 3) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n][totalAbsences][consecutiveLates] != -1) {
            return memo[n][totalAbsences][consecutiveLates];
        }

        int count = 0;
        count = eligibleCombinations(n - 1, totalAbsences, 0) % MOD;
        count = (count + eligibleCombinations(n - 1, totalAbsences + 1, 0)) % MOD;
        count = (count + eligibleCombinations(n - 1, totalAbsences, consecutiveLates + 1)) % MOD;

        return memo[n][totalAbsences][consecutiveLates] = count;
    }

}