class Solution {
    public int maxProductDifference(int[] nums) {
        int[] cloneNums = Arrays.copyOf(nums, nums.length);
        int[] f = getMaxMin(cloneNums);
        int[] s = getMaxMin(cloneNums);

        return f[0] * s[0] - f[1] * s[1];
    }

    private int[] getMaxMin(int[] nums) {
        int len = nums.length;
        int maxi = 0, mini = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
            if (nums[i] < min && nums[i] != Integer.MIN_VALUE) {
                min = nums[i];
                mini = i;
            }
        }
        nums[maxi] = Integer.MIN_VALUE;
        nums[mini] = Integer.MIN_VALUE;
        return new int[]{max, min};
    }
}