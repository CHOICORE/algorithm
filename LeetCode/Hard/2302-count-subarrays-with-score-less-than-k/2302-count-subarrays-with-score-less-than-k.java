class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long answer = 0, total = 0;
        for (int i = 0, j = 0; j < n; j++) {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i];
                i++;
            }
            answer += j - i + 1;
        }
        return answer;
    }
}