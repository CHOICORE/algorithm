class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(count);
                count = 0;
                strings.push(result);
                result = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = result;
                result = strings.pop();
                int repeatCount = counts.pop();
                for (int i = 0; i < repeatCount; i++) {
                    result.append(temp);
                }
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
