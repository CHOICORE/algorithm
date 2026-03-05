class Solution {
    public int minOperations(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    r++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    r++;
                }
            }
        }

        return Math.min(r, s.length() - r);
    }
}