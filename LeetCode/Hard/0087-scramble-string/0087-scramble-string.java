class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean dp[][][] = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean dp1[] = dp[newLength][i];
                        boolean dp2[] = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}

/* Time Limit Exceeded

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        // 두 문자열의 문자 구성이 다르면 스크램블되지 않은 것으로 판단
        if (!isAnagram(s1, s2)) {
            return false;
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // s1의 첫 i개 문자와 s2의 첫 i개 문자가 스크램블된 경우
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // s1의 첫 i개 문자와 s2의 끝 i개 문자가 스크램블된 경우
            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
    
    // 두 문자열이 같은 문자로 이루어져 있는지 확인하는 메서드
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }
        
        int size = 26;
        char c = 'a';
        

        int[] freq = new int[size];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - c]++;
            freq[s2.charAt(i) - c]--;
        }
        
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;

        // 시간 초과
        // char[] arr1 = s1.toCharArray();
        // char[] arr2 = s2.toCharArray();
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // return Arrays.equals(arr1, arr2);
    }

}
*/