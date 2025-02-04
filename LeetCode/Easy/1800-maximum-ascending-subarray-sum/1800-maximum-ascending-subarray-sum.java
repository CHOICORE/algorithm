class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;

        for (int startIdx = 0; startIdx < nums.length; startIdx++) {
            int currentSubarraySum = nums[startIdx];

            for (
                    int endIdx = startIdx + 1;
                    endIdx < nums.length && nums[endIdx] > nums[endIdx - 1];
                    endIdx++
            ) {
                currentSubarraySum += nums[endIdx];
            }
            
            maxSum = Math.max(maxSum, currentSubarraySum);
        }

        return maxSum;
    }
}