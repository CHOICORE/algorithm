class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int r = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            r = Math.min(r, nums[i + k - 1] - nums[i]);
        }
        return r;
    }
}