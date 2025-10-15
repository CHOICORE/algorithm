class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int c = 1;
        int t = 0;
        int r = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++c;
            } else {
                t = c;
                c = 1;
            }
            r = Math.max(r, Math.min(t, c));
            r = Math.max(r, c / 2);
        }

        return r;
    }
}