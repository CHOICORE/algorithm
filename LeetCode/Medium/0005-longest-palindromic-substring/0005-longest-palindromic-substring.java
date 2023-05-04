class Solution {
    int start = -1;
    int length = 0;
    public String longestPalindrome(String s) {
        this.start = -1;
        this.length = 0;
        explore(s, s.length() / 2, 0);
        return this.start == -1 ? null : s.substring(this.start, this.start + this.length);
    }

    public void explore(String s, int index, int direction) {
        int i = index - 1;
        int j = index + 1;
        while (i >= 0 && s.charAt(i) == s.charAt(index))
            i--;
        while (j < s.length() && s.charAt(j) == s.charAt(index))
            j++;
        int l = i;
        int r = j;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        if (r - l > length) {
            this.length = r - l;
            this.start = l;
        }
        if (direction != 2 && 2 * (i + 1) > this.length)
            explore(s, i, 1);
        if (direction != 1 && 2 * (s.length() - j) > this.length)
            explore(s, j, 2);
    }
}