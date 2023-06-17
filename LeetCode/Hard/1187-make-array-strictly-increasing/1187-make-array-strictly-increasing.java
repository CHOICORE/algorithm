class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int INF = 1 << 30;
        Arrays.sort(arr2);
        int m = 0;
        for (int x : arr2) {
            if (m == 0 || x != arr2[m - 1]) {
                arr2[m++] = x;
            }
        }
        int n = arr1.length;

        int[] arr11 = new int[n + 2];
        arr11[0] = -INF;
        arr11[n + 1] = INF;
        int e0 = 1;
        for (int e : arr1) {
            arr11[e0++] = e;
        }
        int[] dp = new int[n + 2];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < n + 2; i++) {
            int j = search(arr2, arr11[i], m);
            for (int k = 1; k <= j && k < i; k++) {
                if (arr11[i - k - 1] < arr2[j - k])
                    dp[i] = Math.min(dp[i], dp[i - k - 1] + k);
            }
            if (arr11[i] > arr11[i - 1]) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }

        }
        return dp[n + 1] >= INF ? -1 : dp[n + 1];


    }

    private int search(int[] nums, int x, int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int binarySearch(int[] arr1, int i, int[] arr22) {
        int l = 0, r = arr22.length - 1;
        int p = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr22[mid] >= arr1[i]) {
                p = mid;
                r = mid - 1;

            } else {
                l = mid + 1;

            }
        }
        return p;
    }
}