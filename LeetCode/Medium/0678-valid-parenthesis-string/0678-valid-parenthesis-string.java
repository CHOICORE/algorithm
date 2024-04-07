class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                max++;
                min++;
            } else if (s.charAt(i) == ')') {
                max--;
                min--;
            } else {
                max++;
                min--;
            }
            if (max < 0) {
                return false;
            }
            min = Math.max(0, min);
        }
        return min == 0;
    }
}