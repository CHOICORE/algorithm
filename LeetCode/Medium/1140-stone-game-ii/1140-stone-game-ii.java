class Solution {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] memo = new int[2][n + 1][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return play(piles, 0, 0, 1, memo);
    }

    private int play(int[] piles, int player, int index, int M, int[][][] memo) {
        if (index == piles.length) {
            return 0;
        }

        if (memo[player][index][M] != -1) {
            return memo[player][index][M];
        }

        int score = player == 0 ? 0 : Integer.MAX_VALUE;
        int rocksGained = 0;
        for (int x = 1; x <= Math.min(piles.length - index, 2 * M); x++) {
            rocksGained += piles[index + x - 1];
            if (player == 0) {
                score = Math.max(score, rocksGained + play(piles, 1 - player, index + x, Math.max(x, M), memo));
            } else {
                score = Math.min(score, play(piles, 1 - player, index + x, Math.max(x, M), memo));
            }
        }
        memo[player][index][M] = score;
        return score;
    }

}