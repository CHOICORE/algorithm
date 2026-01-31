class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char r = letters[0];
        boolean flag = false;

        for (char ch : letters) {
            if (!flag) {
                if (ch > target) {
                    r = ch;
                    flag = true;
                }
            } else {
                if (ch > target && ch < r) r = ch;
            }
        }

        return r;
    }
}