class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] d = new boolean[nums.length + 1];
        for (final int num : nums) {
            if (d[num]) return num;

            d[num] = true;
        }
        return -1;
    }
}