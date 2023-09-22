class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = t.length(), m = s.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        if (m < 1) return true;

        while (i < n) {
            if (tCharArray[i] == sCharArray[j]) {
                j++;
            }
            i++;
            if (j == m) return true;
        }
        return false;
    }
}
