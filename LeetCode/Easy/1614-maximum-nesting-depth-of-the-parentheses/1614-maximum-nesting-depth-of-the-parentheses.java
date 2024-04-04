class Solution {
    public int maxDepth(String s) {
        int answer = 0;

        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                st.pop();
            }

            answer = Math.max(answer, st.size());
        }

        return answer;
    }
}