class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[123];
        int left = 0, right = 0, count = t.length(), tmp = Integer.MAX_VALUE, start = 0;

        for (char c : t.toCharArray())
            map[c]++;

        char[] ch = s.toCharArray();
        while (right < s.length()) {
            if (map[ch[right++]]-- > 0) count--;

            while (count == 0) {
                if ((right - left) < tmp) tmp = right - (start = left);
                if (map[ch[left++]]++ == 0) count++;
            }
        }

        return tmp == Integer.MAX_VALUE ? "" : s.substring(start, start + tmp);
    }
}