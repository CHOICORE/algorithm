class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccurrence = word.indexOf(ch);
        if (firstOccurrence == -1) {
            return word;
        }

        StringBuilder prefix = new StringBuilder(word.substring(0, firstOccurrence + 1));
        return prefix.reverse().toString() + word.substring(firstOccurrence + 1);
    }
}