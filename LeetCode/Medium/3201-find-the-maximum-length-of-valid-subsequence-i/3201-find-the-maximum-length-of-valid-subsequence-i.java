class Solution {
    static int[][] PATTERNS = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    public int maximumLength(int[] nums) {
        int r = 0;
        
        for (int[] pattern : PATTERNS) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            r = Math.max(r, cnt);
        }
        return r;
    }
}