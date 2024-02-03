class Solution {
    int sum(int[] arr, int i, int n) {
        int sum = Integer.MIN_VALUE;
        int j = i;
        for (; i <= n; i++) {
            sum = Math.max(sum, arr[i]);
        }
        return sum * (n - j + 1);
    }

    public int maxSum(int[] arr, int k, int n, int[] t) {
        if (t[n] != -1)
            return t[n];
        if (k >= n + 1) {
            t[n] = sum(arr, 0, n);
            return t[n];
        }

        int max = Integer.MIN_VALUE;
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (n < k)
                break;
            max = Math.max(max, arr[n - i]);
            answer = Math.max(answer, (i + 1) * max + maxSum(arr, k, n - i - 1, t));
            t[n] = answer;

        }
        return answer;


    }

    int maxSumAfterPartitioning(int[] arr, int k) {
        int[] t = new int[arr.length];
        Arrays.fill(t, -1);

        return maxSum(arr, k, arr.length - 1, t);
    }
}