class Solution {
    public static int iterateString(int n, String s) {
        if (n == s.length() - 1)
            return 0;
        return Math.abs(s.charAt(n) - s.charAt(n + 1)) + iterateString(n + 1, s);
    }

    public int scoreOfString(String s) {
        return iterateString(0, s);
    }
}