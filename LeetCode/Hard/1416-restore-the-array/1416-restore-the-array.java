class Solution {
    public int numberOfArrays(String s, int k) {
        int sz = s.length();
        int[] m = new int[sz + 1];
        m[sz] = 1;
        for (int i = sz - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                m[i] = 0;
                continue;
            }
            long r = 0;
            for (int j = i; j < sz; j++) {
                r = r * 10 + (s.charAt(j) - '0');
                if (r > k) {
                    break;
                }
                m[i] = (m[i] + m[j + 1]) % 1_000_000_007;
            }
        }
        return m[0];
    }
}