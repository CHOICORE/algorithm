class Solution {
    public String clearDigits(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        while (i < sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}