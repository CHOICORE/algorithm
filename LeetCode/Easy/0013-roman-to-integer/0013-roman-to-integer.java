class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            int value = getSymbolValue(s.charAt(i));
            if (i < size - 1 && value < getSymbolValue(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }

    private int getSymbolValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}