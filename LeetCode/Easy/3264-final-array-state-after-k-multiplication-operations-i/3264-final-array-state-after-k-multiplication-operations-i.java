class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            int min = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
            
            nums[min] *= multiplier;
        }

        return nums;
    }
}