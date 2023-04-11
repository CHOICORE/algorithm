class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        if (answer.length() == 0) {
            return "";
        }

        return answer.reverse().toString();
    }
}
