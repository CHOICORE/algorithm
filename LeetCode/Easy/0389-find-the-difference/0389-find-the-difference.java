class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char sCharArr : s.toCharArray()) c ^= sCharArr;
        for (char tCharArr : t.toCharArray()) c ^= tCharArr;
        return c;
    }
}