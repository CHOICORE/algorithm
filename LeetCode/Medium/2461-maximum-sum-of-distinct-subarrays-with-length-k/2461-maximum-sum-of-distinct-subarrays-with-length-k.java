class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = 0;
        long sum = 0;
        int begin = 0;
        int end = 0;

        Map<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                sum -= nums[begin];
                begin++;
            }
            numToIndex.put(currNum, end);
            sum += nums[end];
            if (end - begin + 1 == k) {
                answer = Math.max(answer, sum);
            }
            end++;
        }
        return answer;
    }
}