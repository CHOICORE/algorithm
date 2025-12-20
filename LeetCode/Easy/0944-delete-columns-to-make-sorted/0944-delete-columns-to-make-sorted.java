class Solution {
    public int minDeletionSize(String[] strs) {
        int r = 0;
        for (int j = 0; j < strs[0].length(); j++) r += isUnsorted(strs, j);
        return r;
    }

    private int isUnsorted(String[] s, int j) {
        for (int i = 1; i < s.length; i++)
            if (s[i].charAt(j) < s[i - 1].charAt(j))
                return 1;
        return 0;
    }
}
