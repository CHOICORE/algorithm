class Solution {
    
    public long minCost(int[] nums, int[] cost) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i : nums) {
            l = Math.min(l, i);
            r = Math.max(r, i);
        }
        long ans = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            long cost1 = find(nums, cost, m);
            long cost2 = find(nums, cost, m + 1);
            ans = Math.min(cost1, cost2);
            if (cost1 <= cost2) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    long find(int[] nums, int[] cost, int target) {
        long abs = 0;
        for (int i = 0; i < nums.length; ++i)
            abs += Math.abs(nums[i] - target) * (long) cost[i];
        return abs;
    }
}