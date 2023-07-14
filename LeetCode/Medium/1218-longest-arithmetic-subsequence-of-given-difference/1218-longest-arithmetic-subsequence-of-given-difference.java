class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int i = arr.length - 1;
        while (i >= 0) {
            int k = arr[i];
            if (k < min) min = k;
            if (k > max) max = k;
            i--;
        }
        int[] dp = new int[max - min + 1];

        max = 1;
        int k = 0;
        while (k < arr.length) {
            int j = arr[k];
            int cur = j - min, pred = cur - difference;
            if (pred >= 0 && pred < dp.length) {
                dp[cur] = 1 + dp[pred];
                if (dp[cur] > max) max = dp[cur];
            } else {
                dp[cur] = 1;
            }

            k++;
        }
        return max;
    }
}