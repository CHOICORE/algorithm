class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        for (String word : words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int result = 0;
        boolean central = false;
        for (int i = 0; i < 26; i++) {
            if (count[i][i] % 2 == 0) {
                result += count[i][i];
            } else {
                result += count[i][i] - 1;
                central = true;
            }
            for (int j = i + 1; j < 26; j++) {
                result += 2 * Math.min(count[i][j], count[j][i]);
            }
        }
        if (central) {
            result++;
        }
        return result * 2;
    }
}