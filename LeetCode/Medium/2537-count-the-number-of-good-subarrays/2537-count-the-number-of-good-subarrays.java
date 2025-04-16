class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int same = 0, right = -1;
        Map<Integer, Integer> cnt = new HashMap<>();
        long answer = 0;
        for (int num : nums) {
            while (same < k && right + 1 < n) {
                ++right;
                same += cnt.getOrDefault(nums[right], 0);
                cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            }
            if (same >= k) {
                answer += n - right;
            }
            cnt.put(num, cnt.get(num) - 1);
            same -= cnt.get(num);
        }
        return answer;
    }
}