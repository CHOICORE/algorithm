class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[(s.charAt(i) - 'a')];
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            var ch = order.charAt(i);
            var idx = (int) (ch - 'a');
            var c = count[idx];
            count[idx] = 0;
            if (c > 0) {
                for (int j = 0; j < c; ++j) {
                    builder.append(ch);
                }
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                final var ch = (char) (i + 'a');
                for (int j = 0; j < count[i]; ++j) {
                    builder.append(ch);
                }
            }
        }
        return builder.toString();
    }
}