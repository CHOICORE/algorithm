class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastOp = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastOp == '+') {
                    stack.push(num);
                } else if (lastOp == '-') {
                    stack.push(-num);
                } else if (lastOp == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastOp == '/') {
                    stack.push(stack.pop() / num);
                }
                lastOp = c;
                num = 0;
            }
        }
        int result = 0;
        for (int numInStack : stack) {
            result += numInStack;
        }
        return result;
    }
}
