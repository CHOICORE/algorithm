class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;

        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, right, index);
                right--;
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}