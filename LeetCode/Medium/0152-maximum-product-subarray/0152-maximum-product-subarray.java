class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = maxEndingHere;
            maxEndingHere = Math.max(Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]), nums[i]);
            minEndingHere = Math.min(Math.min(temp * nums[i], minEndingHere * nums[i]), nums[i]);
            maxProd = Math.max(maxProd, maxEndingHere);
        }
        return maxProd;
    }
}
