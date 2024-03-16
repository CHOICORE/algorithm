class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[2 * len + 2];
        int current = len;
        int result = 0;

        for (int i = 0; i < len; i++) {
            current += (nums[i] << 1) - 1;
            if (current == len) {
                result = i + 1;
            } else if (tmp[current] == 0) {
                tmp[current] = i + 1;
            } else {
                result = Math.max(result, i - tmp[current] + 1);
            }
        }
        return result;
    }
}