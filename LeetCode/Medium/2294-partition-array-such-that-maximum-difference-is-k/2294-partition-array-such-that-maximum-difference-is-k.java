class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int r = 1;
        int rec = nums[0];
        for (int num : nums) {
            if (num - rec > k) {
                r++;
                rec = num;
            }
        }
        return r;
    }
}