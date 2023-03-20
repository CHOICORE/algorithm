class Solution {
    public boolean isSubsequence(String s, String t) {
        int sCheckSum = 0, tCheckSum = 0;
        while (sCheckSum < s.length() && tCheckSum < t.length()) {
            if (s.charAt(sCheckSum) == t.charAt(tCheckSum)) {
                sCheckSum++;
            }
            tCheckSum++;
        }
        return sCheckSum == s.length();
    }
}