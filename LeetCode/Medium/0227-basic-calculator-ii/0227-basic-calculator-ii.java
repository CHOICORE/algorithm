class Solution {
    public int calculate(String s) {
        int number = 0;
        int n1 = 0;
        int n2 = 1;
        char op1 = '+';
        char op2 = '*';
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                number = number * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                n1 = eval(n1, op1, (eval(n2, op2, number)));
                op1 = c;
                n2 = 1;
                op2 = '*';
                number = 0;
            } else if (c == '*' || c == '/') {
                n2 = eval(n2, op2, number);
                op2 = c;
                number = 0;
            }
        }
        return eval(n1, op1, (eval(n2, op2, number)));
    }

    private int eval(int n1, char op, int n2) {
        if (op == '+') {
            return n1 + n2;
        } else if (op == '-') {
            return n1 - n2;
        } else if (op == '*') {
            return n1 * n2;
        } else {
            return n1 / n2;
        }
    }
}