class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] dp = new int[max - min + 1];
        int res = 1;
        int i = 0;
        while (i < arr.length) {
            int curr = arr[i] - min;
            int prev = curr - difference;
            if (prev >= 0 && prev < dp.length) {
                dp[curr] = dp[prev] + 1;
            } else {
                dp[curr] = 1;
            }
            res = Math.max(res, dp[curr]);
            i++;
        }
        return res;
    }
}