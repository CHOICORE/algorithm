class Solution {
    int result = Integer.MAX_VALUE;
    private int[][] dp;
    private char[] chars;
    private int n;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }

    private void backtracking(List<Integer> data, int index, int k) {
        if (index == data.size() || k == 0) {
            int tmp = 0;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) != 0) {
                    tmp += (1 + ((data.get(i) != 1) ? String.valueOf(data.get(i)).length() : 0));
                }
            }
            result = Math.min(result, tmp);
            return;
        }
        for (int i = 0; i <= Math.min(k, data.get(index)); i++) {
            if (k - i >= 0) {
                int count = data.get(index);
                data.set(index, count - i);
                backtracking(data, index + 1, k - i);
                data.set(index, count + i);
            }
        }
    }

    private int dp(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;

        int result = dp[i][k];
        if (result != -1) return result;
        result = dp(i + 1, k - 1);
        int length = 0, same = 0, diff = 0;

        for (int j = i; j < n && diff <= k; j++) {

            if (chars[j] == chars[i]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++;
            }
            result = Math.min(result, length + dp(j + 1, k - diff));
        }
        dp[i][k] = result;
        return result;
    }
}