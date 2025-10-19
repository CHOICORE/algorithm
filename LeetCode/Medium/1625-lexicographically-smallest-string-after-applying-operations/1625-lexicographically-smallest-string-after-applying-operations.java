class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        boolean[] visited = new boolean[n];

        String r = s;
        s += s;

        for (int i = 0; !visited[i]; i = (i + b) % n) {
            visited[i] = true;
            for (int j = 0; j < 10; j++) {
                int kLimit = b % 2 == 0 ? 0 : 9;
                for (int k = 0; k <= kLimit; k++) {

                    char[] t = s.substring(i, i + n).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        t[p] = (char) ('0' + ((t[p] - '0' + j * a) % 10));
                    }
                    for (int p = 0; p < n; p += 2) {
                        t[p] = (char) ('0' + ((t[p] - '0' + k * a) % 10));
                    }
                    String tStr = new String(t);
                    if (tStr.compareTo(r) < 0) {
                        r = tStr;
                    }
                }
            }
        }
        
        return r;
    }
}