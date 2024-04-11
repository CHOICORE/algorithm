class Solution {
    public static String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        if (k == num.length()) {
            return "0";
        }

        char[] stack = new char[digits.length];
        int top = -1;
        int remove = k;

        for (char digit : digits) {
            while (remove > 0 && top >= 0 && stack[top] > digit) {
                top--;
                remove--;
            }
            top++;
            stack[top] = digit;
        }

        int i = 0;
        while (stack[i] == '0' && i < digits.length - k - 1) {
            i++;
        }

        return String.valueOf(stack, i, digits.length - k - i);
    }
}