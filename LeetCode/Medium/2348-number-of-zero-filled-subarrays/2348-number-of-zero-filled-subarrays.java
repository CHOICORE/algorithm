class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < n && nums[j] == 0) {
                j++;
            }
            int len = j - i;
            count += (long) len * (len + 1) / 2;
            i = j;
        }
        return count;
    }
}