class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            for (int i = 1; i < len; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}