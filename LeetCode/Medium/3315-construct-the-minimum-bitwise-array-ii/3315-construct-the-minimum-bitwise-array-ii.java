class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int r = -1;
            int d = 1;
            while ((x & d) != 0) {
                r = x - d;
                d <<= 1;
            }
            result[i] = r;
        }
        return result;
    }
}
