class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long answer = 0, start = 0;
        int maxElementsInWindow = 0;

        for (int num : nums) {
            if (num == maxElement) {
                maxElementsInWindow++;
            }
            while (maxElementsInWindow == k) {
                if (nums[(int) start] == maxElement) {
                    maxElementsInWindow--;
                }
                start++;
            }
            answer += start;
        }
        return answer;
    }
}