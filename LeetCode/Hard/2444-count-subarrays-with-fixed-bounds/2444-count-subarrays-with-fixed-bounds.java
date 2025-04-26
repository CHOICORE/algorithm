class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                min.clear();
                max.clear();
                left = i + 1;
                continue;
            }
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) min.pollLast();
            min.offerLast(i);
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) max.pollLast();
            max.offerLast(i);
            if (nums[min.peekFirst()] == minK && nums[max.peekFirst()] == maxK) {
                int start = Math.min(min.peekFirst(), max.peekFirst());
                count += (start - left + 1);
            }
        }
        return count;
    }
}