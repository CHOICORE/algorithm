class Solution {
    int literal = 1_000;

    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            nums[i] += literal * (nums[nums[i]] % literal);
        }
        for (int i = 0; i < n; ++i) {
            nums[i] /= literal;
        }
        return nums;
    }
}