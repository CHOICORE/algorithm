class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int lengthStr1 = str1.length();

        for (int mask = 0; mask < (1 << lengthStr1); mask++) {
            StringBuilder temp = new StringBuilder(str1);

            for (int str1Index = 0; str1Index < lengthStr1; str1Index++) {
                if ((mask & (1 << str1Index)) != 0) {
                    temp.setCharAt(
                            str1Index,
                            getNextChar(temp.charAt(str1Index))
                    );
                }
            }

            if (isSubsequence(temp.toString(), str2)) {
                return true;
            }
        }

        return false;
    }

    private char getNextChar(char str1Char) {
        return str1Char == 'z' ? 'a' : (char) (str1Char + 1);
    }

    private boolean isSubsequence(String str1, String str2) {
        int str1Index = 0, str2Index = 0;
        int lengthStr1 = str1.length(), lengthStr2 = str2.length();

        while (str1Index < lengthStr1 && str2Index < lengthStr2) {
            if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
                str2Index++;
            }
            str1Index++;
        }
        return str2Index == lengthStr2;
    }
}