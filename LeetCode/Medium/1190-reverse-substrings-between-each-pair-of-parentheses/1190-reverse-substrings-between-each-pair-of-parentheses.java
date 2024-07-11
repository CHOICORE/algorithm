class Solution {
    int i = 0;

    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder();

        while (i < s.length) {
            if (s[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s[i] == '(') {
                i++;
                sb.append(helper(s));
            } else {
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}