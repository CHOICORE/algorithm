class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long answer = -1;
        for (int num : nums) {
            if (num < sum) {
                answer = num + sum;
            }
            sum += num;
        }
        return answer;
    }
}