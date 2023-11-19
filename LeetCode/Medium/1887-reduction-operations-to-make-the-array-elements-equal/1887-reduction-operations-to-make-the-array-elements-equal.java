class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int up = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }

            answer += up;
        }

        return answer;
    }
}