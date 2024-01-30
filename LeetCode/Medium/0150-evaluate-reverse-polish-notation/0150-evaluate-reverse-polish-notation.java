class Solution {
    int pos;

    public int evalRPN(String[] tokens) {
        this.pos = tokens.length - 1;
        return evaluate(tokens);
    }

    public int evaluate(String[] t) {
        String token = t[pos];
        pos--;
        switch (token) {
            case "+" -> {
                return evaluate(t) + evaluate(t);
            }
            case "*" -> {
                return evaluate(t) * evaluate(t);
            }
            case "-" -> {
                return -evaluate(t) + evaluate(t);
            }
            case "/" -> {
                int right = evaluate(t);
                return evaluate(t) / right;
            }
            default -> {
                return Integer.parseInt(token);
            }
        }
    }
}