class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] counter = new int[20_001];
        for (final int num : nums) {
            counter[num + 10_000]++;
        }
        int cnt = 0;
        for (int i = counter.length - 1; i >= 0; i--) {
            cnt += counter[i];
            if (cnt >= k) {
                return i - 10_000;
            }
        }
        return -1;
    }
}