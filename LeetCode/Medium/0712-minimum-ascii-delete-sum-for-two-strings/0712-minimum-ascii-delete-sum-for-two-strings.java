class Solution {
    public int minimumDeleteSum(String string1, String string2) {
        if (string1.length() < string2.length()) return minimumDeleteSum(string2, string1);
        char[] s1 = string1.toCharArray(), s2 = string2.toCharArray();
        int[] memo = getData(s2);
        int[] ps = getData(s1);
        for (int i = s1.length - 1; i > -1; i--) {
            int last = ps[i], prevLast = i < s1.length - 1 ? ps[i + 1] : 0;
            for (int j = s2.length - 1; j > -1; j--) {
                int tmp = memo[j];
                if (s1[i] == s2[j]) last = memo[j] = prevLast;
                else last = memo[j] = Math.min(memo[j] + s1[i], last + s2[j]);
                prevLast = tmp;
            }
        }
        return memo[0];
    }

    private int[] getData(char[] str) {
        int strLen = str.length;
        int[] data = new int[strLen];
        data[data.length - 1] = str[strLen - 1];
        for (int i = data.length - 2; i > -1; i--) {
            data[i] += data[i + 1] + str[i];
        }
        return data;
    }
}