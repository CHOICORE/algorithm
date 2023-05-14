class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int bitmask = 0;
        for (int i = 0; i < n; i++) {
            bitmask = bitmask | (1 << i);
        }
        int[] memo = new int[bitmask + 1];
        return findMaxScore(nums, bitmask, n / 2, memo);
    }

    private int findMaxScore(int[] nums, int bitmask, int pairsToDelete, int[] memo) {
        if (memo[bitmask] > 0) {
            return memo[bitmask];
        }

        int maxScore = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int first = 1 << i;
            if ((bitmask & first) == 0) {
                continue;
            }
            bitmask = bitmask ^ first;
            for (int j = i + 1; j < nums.length; j++) {
                int score = 0;
                int second = 1 << j;
                if ((bitmask & second) == 0) {
                    continue;
                }
                bitmask = bitmask ^ second;
                score += pairsToDelete * findGCD(nums[i], nums[j]);
                score += findMaxScore(nums, bitmask, pairsToDelete - 1, memo);
                bitmask = bitmask ^ second;
                maxScore = Math.max(maxScore, score);
            }
            bitmask = bitmask ^ first;
        }
        memo[bitmask] = maxScore;
        return memo[bitmask];
    }

    private int findGCD(int small, int big) {
        if (big % small == 0) {
            return small;
        }
        return findGCD(big % small, small);
    }
}