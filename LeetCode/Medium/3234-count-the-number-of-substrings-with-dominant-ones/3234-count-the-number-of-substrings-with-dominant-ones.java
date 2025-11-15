class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i - 1) == '0') {
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int r = 0;
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;
            while (j > 0 && c * c <= n) {
                int t = (i - pre[j]) - c;
                if (c * c <= t) {
                    r += Math.min(j - pre[j], t - c * c + 1);
                }
                j = pre[j];
                c++;
            }
        }
        return r;
    }
}