class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        char last = words[n - 1].charAt(words[n - 1].length() - 1);

        for (String word : words) {
            if (word.charAt(0) != last) return false;
            last = word.charAt(word.length() - 1);
        }

        return true;
    }
}