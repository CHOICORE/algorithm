class Solution {

    public int getLucky(String s, int k) {
        StringBuilder numeric = new StringBuilder();
        for (char ch : s.toCharArray()) {
            numeric.append(Integer.toString(ch - 'a' + 1));
        }

        while (k-- > 0) {
            int digitSum = 0;
            for (char digit : numeric.toString().toCharArray()) {
                digitSum += digit - '0';
            }
            numeric = new StringBuilder(Integer.toString(digitSum));
        }

        return Integer.parseInt(numeric.toString());
    }
}