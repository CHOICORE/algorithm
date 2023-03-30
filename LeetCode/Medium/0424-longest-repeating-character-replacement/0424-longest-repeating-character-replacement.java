class Solution {
    public int characterReplacement(String s, int k) {
        // s, k는 영문 소문자만
        int[] frequencyMap = new int[26];
        
        int left = 0, right = 0;
        int maxCount = 0, maxLength = 0;
        while (right < s.length()) {
            char curr = s.charAt(right++);
            maxCount = Math.max(maxCount, ++frequencyMap[curr - 'A']);
            if (right - left - maxCount > k) {
                frequencyMap[s.charAt(left++) - 'A']--;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
