class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] msw = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int max;
        int window;
        for (int i = 0; i < nums.length; i += k) {
            window = Math.min(i + k - 1, nums.length - 1);
            max = Integer.MIN_VALUE;
            for (int j = i; j <= window; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                left[j] = max;
            }
            max = Integer.MIN_VALUE;
            for (int j = window; j >= i; j--) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                right[j] = max;
            }
        }
        int j;
        for (int i = 0; i < msw.length; i++) {
            j = i + k - 1;
            msw[i] = Math.max(right[i], left[j]);
        }
        return msw;
    }
}