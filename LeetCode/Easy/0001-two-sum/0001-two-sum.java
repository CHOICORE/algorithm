class Solution {
    public int[] twoSum(int[] nums, int k) {
        int[] ans = new int[2];
        int i = 0, j = 1;
        int n = nums.length;
        while (i < n) {
            if (i + j >= n) {
                j++;
                i = 0;
                continue;
            } else {
                if (nums[i] + nums[i + j] == k) {
                    ans[0] = i;
                    ans[1] = i + j;
                    break;
                }
            }
            i++;
        }
        return ans;
    }
}