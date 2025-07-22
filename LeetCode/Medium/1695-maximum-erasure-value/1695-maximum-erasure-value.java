class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10_001];
        int l = 0;
        int c = 0;
        int m = 0;

        for (int num : nums) {
            while (seen[num]) {
                c -= nums[l];
                seen[nums[l]] = false;
                l++;
            }
            c += num;
            seen[num] = true;
            if (c > m) {
                m = c;
            }
        }

        return m;
    }
}