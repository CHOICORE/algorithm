class Solution {
    public int minOperations(String s) {
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    index++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    index++;
                }
            }
        }

        return Math.min(index, s.length() - index);
    }
}