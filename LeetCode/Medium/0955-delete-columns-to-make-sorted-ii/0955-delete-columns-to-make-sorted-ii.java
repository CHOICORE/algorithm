class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int l = strs[0].length();
        int r = 0;

        String[] cur = new String[n];
        for (int j = 0; j < l; ++j) {
            String[] tmp = Arrays.copyOf(cur, n);
            for (int i = 0; i < n; ++i)
                tmp[i] += strs[i].charAt(j);

            if (isSorted(tmp))
                cur = tmp;
            else
                r++;
        }

        return r;
    }

    public boolean isSorted(String[] strs) {
        for (int i = 0; i < strs.length - 1; ++i) {
            if (strs[i].compareTo(strs[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}