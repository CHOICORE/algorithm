class Solution {
    public int appendCharacters(String s, String t) {
        if (s.equals(t)) return 0;
        char charS[] = s.toCharArray();
        char charT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = charS.length, n = charT.length;
        for (; i < m; i++) {
            if (charS[i] == charT[j]) j++;
            if (j == n) return 0;
        }
        
        return n - j;
    }
}