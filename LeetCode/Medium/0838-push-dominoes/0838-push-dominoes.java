class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] charArray = dominoes.toCharArray();
        int i = 0;
        while (i < n) {
            if (charArray[i] != '.') {
                i++;
                continue;
            }
            int j = i;
            while (j < n && charArray[j] == '.')
                j++;
            if (i - 1 >= 0 && j < n) {
                if (charArray[i - 1] == charArray[j]) {
                    int k = i;
                    while (k < j)
                        charArray[k++] = charArray[i - 1];
                } else {
                    if (charArray[i - 1] == 'R') {
                        int u = i, v = j - 1;
                        while (u < v) {
                            charArray[u++] = 'R';
                            charArray[v--] = 'L';
                        }
                    }
                }
            } else if (i - 1 >= 0) {
                if (charArray[i - 1] == 'R') {
                    int k = i;
                    while (k < j)
                        charArray[k++] = 'R';
                }
            } else if (j < n) {
                if (charArray[j] == 'L') {
                    int k = i;
                    while (k < j)
                        charArray[k++] = 'L';
                }
            }
            i = j;
        }
        return String.valueOf(charArray);
    }
}