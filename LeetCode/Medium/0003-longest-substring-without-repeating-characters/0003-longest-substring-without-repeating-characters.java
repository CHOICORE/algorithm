class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128];
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < n) {
            char c = s.charAt(right);
            freq[c]++;
            while (freq[c] > 1) {
                char d = s.charAt(left);
                freq[d]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
