class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] answer = new int[nums.length];
        int i = nums.length - 1, square = 0;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }
            answer[i--] = square * square;
        }
        return answer;
    }
}