class Solution {
    public int minimumLength(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            if (chars[i] != chars[j]) break;
            char c = chars[i];
            while (j >= i && chars[i] == c) i++;
            while (j >= i && chars[j] == c) j--;
        }
        return j - i + 1;
    }
}