class Solution {
    public int[] getAverages(int[] nums, int k) {
        int left = 0;
        int right = k * 2 + 1;
        int len = nums.length;
        int[] ans = new int[len];
        long cur = 0;

        Arrays.fill(ans, -1);

        if (k == 0) {
            return nums;
        }

        if ((k * 2 + 1) > len) {
            return ans;
        }

        for (int i = 0; i < (k * 2 + 1); i++) {
            cur += nums[i]; 
        }

        ans[k] = (int) (cur / (k * 2 + 1));

        for (int i = right; i < len; i++) {
            cur -= nums[i - (k * 2 + 1)];
            cur += nums[i];
            ans[i - k] = (int) (cur / (k * 2 + 1));
        }
        return ans;
    }
}


