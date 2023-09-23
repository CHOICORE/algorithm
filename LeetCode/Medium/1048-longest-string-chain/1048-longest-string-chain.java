class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        HashMap<String, Integer> dp = new HashMap<>();
        int maxChain = 0;
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            maxChain = Math.max(maxChain, dp.get(word));
        }
        return maxChain;
    }
}