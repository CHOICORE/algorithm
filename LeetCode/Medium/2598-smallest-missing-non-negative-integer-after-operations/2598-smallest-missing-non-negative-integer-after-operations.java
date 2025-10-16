class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        int[] mp = new int[value];
        for (int x : nums) {
            int v = ((x % value) + value) % value;
            mp[v]++;
        }
        int r = 0;
        while (mp[r % value] > 0) {
            mp[r % value]--;
            r++;
        }
        return r;
    }
}