class Solution {
    public int singleNumber(int[] nums) {
        int o = 0;
        int t = 0;
        for (int num : nums) {
            o = (num ^ o) & ~t;
            t = (num ^ t) & ~o;
        }
        return o;
    }
}