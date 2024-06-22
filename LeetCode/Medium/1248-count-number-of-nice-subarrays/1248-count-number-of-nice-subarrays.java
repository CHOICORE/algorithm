class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] counts = new int[n + 1];
        counts[0] = 1;
        int answer = 0, oddNumbers = 0;
        for (int value : nums) {
            oddNumbers += value & 1;
            if (oddNumbers - k >= 0) {
                answer += counts[oddNumbers - k];
            }
            counts[oddNumbers]++;
        }
        return answer;
    }
}