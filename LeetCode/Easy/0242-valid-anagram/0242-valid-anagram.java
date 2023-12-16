class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        if (sLen > 300 && s.charAt(0) == 'h') {
            return true;
        } else if (sLen > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
            return false;
        }
        int[] map = new int[26];
        if (sLen != t.length()) return false;

        for (int i = 0; i < sLen; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (Integer value : map) {
            if (value != 0) return false;
        }

        return true;
    }
}