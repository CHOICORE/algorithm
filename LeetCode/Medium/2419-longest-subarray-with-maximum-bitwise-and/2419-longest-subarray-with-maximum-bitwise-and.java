class Solution {
    public int longestSubarray(int[] a) {
        int max = 0;
        int c = 0, c1 = 0;
        for (int j : a) {
            if (max < j) max = j;
        }
        for (int j : a) {
            if (max == j) {
                c1++;
                c = Math.max(c, c1);
            } else {
                c1 = 0;
            }
        }

        return c;
    }
}