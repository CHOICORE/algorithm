class Solution {
    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = nums[nums[i]];
        }
        return answer;
    }
}