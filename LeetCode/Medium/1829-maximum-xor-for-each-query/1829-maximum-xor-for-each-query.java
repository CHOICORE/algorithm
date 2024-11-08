class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorProduct = 0;
        for (int num : nums) {
            xorProduct = xorProduct ^ num;
        }
        int[] ans = new int[nums.length];

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = xorProduct ^ mask;
            xorProduct = xorProduct ^ nums[nums.length - 1 - i];
        }

        return ans;
    }
}