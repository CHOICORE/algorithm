class Solution {
    public int longestStrChain(String[] words) {
        List<String>[] wordLists = new List[17]; // 1~16
        List<Integer>[] dp = new List[17];
        for (int i = 1; i < 17; i++) {
            wordLists[i] = new ArrayList<>();
            dp[i] = new ArrayList<>();
        }
        for (String word : words) {
            wordLists[word.length()].add(word);
        }
        for (int i = 0; i < wordLists[1].size(); i++) {
            dp[1].add(1);
        }
        int longestChain = 1;
        for (int i = 2; i < 17; i++) {
            List<String> curr = wordLists[i];
            List<String> prev = wordLists[i - 1];
            List<Integer> currCache = dp[i];
            List<Integer> prevCache = dp[i - 1];
            for (String word : curr) {
                int maxLength = Integer.MIN_VALUE;
                for (int k = 0; k < prev.size(); k++) {
                    if (isPredecessor(prev.get(k), word)) maxLength = Math.max(maxLength, prevCache.get(k));
                }
                if (maxLength == Integer.MIN_VALUE) maxLength = 1;
                else maxLength++;
                currCache.add(maxLength);
                longestChain = Math.max(longestChain, maxLength);
            }
        }
        return longestChain;
    }

    private boolean isPredecessor(String word1, String word2) {
        boolean misMatch = false;
        for (int i = 0, j = 0; i < word1.length(); i++, j++) {
            if (word1.charAt(i) == word2.charAt(j)) continue;
            if (misMatch) return false;
            misMatch = true;
            i--;
        }
        return true;
    }
}