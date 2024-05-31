class Solution {
    public int[] singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }
        answer &= -answer;
        int[] result = new int[2];
        for (int n : nums) {
            if ((answer & n) == 0) result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }
}