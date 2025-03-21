public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxVal = (1 << maximumBit) - 1;
        int[] result = new int[n];
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 0; i < n; i++) {
            result[i] = xor ^ maxVal;
            xor ^= nums[n - 1 - i];
        }

        return result;
    }
}