class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;

        if (n < 2) return false;

        boolean pre3 = true;
        boolean pre2 = false;
        boolean pre1 = nums[0] == nums[1];
        boolean cur;
        for (int i = 2; i < n; ++i) {
            cur = (pre2 && nums[i] == nums[i - 1]) || (pre3 && (nums[i - 2] == nums[i - 1]
                    && nums[i - 1] == nums[i] || nums[i - 2] + 1 == nums[i - 1] && nums[i - 1]
                    + 1 == nums[i]));

            pre3 = pre2;
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}