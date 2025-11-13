class Solution {
    public int maxOperations(String s) {
        int c = 0;
        int r = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                r += c;
            } else {
                c++;
            }
            i++;
        }
        return r;
    }
}