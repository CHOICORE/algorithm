class Solution {
    public int longestSubarray(int[] nums) {
        int length = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int count = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                length = Math.max(length, count);
            } else {
                count = 0;
            }
        }
        return length;
    }
}