class Solution {
    public static int ansBU(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int ansTD(int[] arr1, int[] arr2, int i, int j, int[][] dp) {
        if (i >= arr1.length || j >= arr2.length) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (arr1[i] == arr2[j]) {
                return 1 + ansTD(arr1, arr2, i + 1, j + 1, dp);
            } else {
                return dp[i][j] = Math.max(ansTD(arr1, arr2, i + 1, j, dp), ansTD(arr1, arr2, i, j + 1, dp));
            }
        }
    }

    public static int ans(int[] arr1, int[] arr2, int i, int j) {
        if (i >= arr1.length || j >= arr2.length) {
            return 0;
        } else {
            if (arr1[i] == arr2[j]) {
                return 1 + ans(arr1, arr2, i + 1, j + 1);
            } else {
                return Math.max(ans(arr1, arr2, i + 1, j), ans(arr1, arr2, i, j + 1));
            }
        }
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return ansTD(nums1, nums2, 0, 0, dp);
    }
}