class Solution {
    
    public long minCost(int[] nums, int[] cost) {
        long p = 0;
        TreeMap<Integer, Long> mp = new TreeMap<>();
        int t = 0;

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0L) + (long) cost[i]);
            p += cost[i];
        }
        long cnt = 0;
        for (int i : mp.keySet()) {
            cnt += mp.get(i);
            if (cnt > p / 2) {
                t = i;
                break;
            }
        }

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (long) (Math.abs(t - nums[i])) * (long) (cost[i]);
        }
        return ans;

    }
}