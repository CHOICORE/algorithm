class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] tCounts = new int[128];
        for (char c : t.toCharArray()) tCounts[c]++;


        char[] sc = s.toCharArray();
        int scLen = sc.length;
        int neededCount = t.length();
        int minWindowLen = Integer.MAX_VALUE;
        int minWindowLeft = 0;
        int minWindowPast = 0;
        int leftIdx = 0;
        while (leftIdx < scLen && tCounts[sc[leftIdx]] == 0) leftIdx++;
        int pastIdx = leftIdx;
        while (pastIdx < scLen || neededCount == 0) {
            if (neededCount == 0) {
                if (++tCounts[sc[leftIdx++]] > 0) neededCount++;
            } else {
                if (--tCounts[sc[pastIdx++]] >= 0) neededCount--;
            }
            if (neededCount == 0 && pastIdx - leftIdx < minWindowLen) {
                minWindowLen = pastIdx - leftIdx;
                minWindowLeft = leftIdx;
                minWindowPast = pastIdx;
            }
        }

        return s.substring(minWindowLeft, minWindowPast);
    }
}