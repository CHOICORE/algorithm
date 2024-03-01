class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count1 = 0;
        int count0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            } else {
                count0++;
            }
        }

        return "1".repeat(Math.max(0, count1 - 1)) +
                "0".repeat(Math.max(0, count0)) +
                '1';
    }
}