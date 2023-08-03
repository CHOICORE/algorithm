class Solution {

    char[][] buttons = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        res = new ArrayList<>();
        traverse(1, buttons[digits.charAt(0) - '0' - 2], digits, new StringBuilder());
        return res;
    }

    private void traverse(int idx, char[] button, String digits, StringBuilder sb) {
        if (sb.length() >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (final char c : button) {
            sb.append(c);
            if (idx >= digits.length()) {
                traverse(idx + 1, button, digits, sb);
            } else {
                traverse(idx + 1, buttons[digits.charAt(idx) - '0' - 2], digits, sb);
            }
            sb.setLength(sb.length() - 1);
        }
    }
}
