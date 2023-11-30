class Solution {
    public String solution(String cipher, int code) {
        
        int length = cipher.length();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= length; i++) {
            int index = code * i;
            if (index <= length) {
                sb.append(cipher.charAt(index - 1));
            }

        }
        return sb.toString();
    }
}