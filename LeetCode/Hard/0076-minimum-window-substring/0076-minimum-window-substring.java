class Solution {
    public String minWindow(String s, String t) {
        int[] required = new int[128];
        for (char c : t.toCharArray()) {
            required[c]++;
        }
        int left = 0, right = 0, count = t.length(), minLength = Integer.MAX_VALUE, minLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (required[c] > 0) {
                count--;
            }
            required[c]--;
            while (count == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                char d = s.charAt(left);
                if (required[d] == 0) {
                    count++;
                }
                required[d]++;
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
