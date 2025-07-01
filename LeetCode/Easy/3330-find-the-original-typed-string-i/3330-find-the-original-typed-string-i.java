class Solution {
    public int possibleStringCount(String word) {
        int l = word.length();
        int r = 1;

        for (int i = 1; i < l; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++r;
            }
        }
        return r;
    }
}