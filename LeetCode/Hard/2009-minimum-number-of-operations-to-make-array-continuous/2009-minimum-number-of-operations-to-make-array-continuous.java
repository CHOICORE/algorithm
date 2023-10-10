class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int ans = len;
        int j = 0;

        Arrays.sort(nums);
        int m = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[m] = nums[i];
                m++;
            }
        }

        for (int i = 0; i < m; ++i) {
            while (j < m && nums[j] < nums[i] + len) {
                ++j;
            }

            ans = Math.min(ans, len - j + i);
        }

        return ans;
    }
}