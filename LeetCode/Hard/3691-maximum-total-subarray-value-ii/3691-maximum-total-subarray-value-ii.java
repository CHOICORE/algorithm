class Solution {

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int logn = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[n][logn];
        int[][] stMin = new int[n][logn];
        for (int i = 0; i < n; i++) {
            stMax[i][0] = stMin[i][0] = nums[i];
        }
        for (int j = 1; j < logn; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(
                        stMax[i][j - 1],
                        stMax[i + (1 << (j - 1))][j - 1]
                );
                stMin[i][j] = Math.min(
                        stMin[i][j - 1],
                        stMin[i + (1 << (j - 1))][j - 1]
                );
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            helper(stMax, stMin, pq, l, n);
        }
        long ans = 0;
        while (k-- > 0) {
            int[] top = pq.poll();
            ans += top[0];
            int l = top[1];
            int r = top[2];
            if (r > l) {
                helper(stMax, stMin, pq, l, r);
            }
        }
        return ans;
    }

    private void helper(final int[][] stMax, final int[][] stMin, final PriorityQueue<int[]> pq, final int l, final int r) {
        int j = 31 - Integer.numberOfLeadingZeros(r - 1 - l + 1);
        int mx = Math.max(stMax[l][j], stMax[r - 1 - (1 << j) + 1][j]);
        int mn = Math.min(stMin[l][j], stMin[r - 1 - (1 << j) + 1][j]);
        pq.offer(new int[]{mx - mn, l, r - 1});
    }
}