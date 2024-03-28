class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        int[] freq = new int[max - min + 1];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            int currVal = nums[right] - min;
            freq[currVal]++;

            while (freq[currVal] > k) {
                freq[nums[left] - min]--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}