class Solution {
    public boolean search(int[] nums, int target) {

        int n = nums.length;

        for (final int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}