class Solution {
    public int solve(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int j = 0;
        int i = 0;
        int sum = 0;
        int ans = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (sum > k && j < nums.length) {
                sum -= nums[j];
                j++;
            }
            if (sum <= k) {
                ans += i - j + 1;
            }
            i++;
        }
        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = solve(nums, goal);
        int y = solve(nums, goal - 1);
        return x - y;
    }
}