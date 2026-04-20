class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    r = Math.max(r, j - i);
                }
            }
        }
        return r;
    }
}