class Solution {
    public long minCost(int[] nums, int[] cost) {

        long minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

        for (int n : nums) {
            
            minValue = Math.min(minValue, n);
            
            maxValue = Math.max(maxValue, n);
            
        }

        long res = find(nums, cost, minValue);

        while (minValue < maxValue) {
            
            long mid = minValue + (maxValue - minValue) / 2;
            
            long leftCost = find(nums, cost, mid);
            
            long rightCost = find(nums, cost, mid + 1);
            
            res = Math.min(leftCost, rightCost);
            
            if (leftCost < rightCost) {
                
                maxValue = mid;
                
            } else {
                
                minValue = mid + 1;
                
            }
        }
        
        return res;
    }

    public long find(int[] nums, int[] cost, long x) {
        
        long res = 0L;
        
        for (int i = 0; i < nums.length; i++) res += Math.abs(nums[i] - x) * cost[i];
        
        return res;
        
    }
}