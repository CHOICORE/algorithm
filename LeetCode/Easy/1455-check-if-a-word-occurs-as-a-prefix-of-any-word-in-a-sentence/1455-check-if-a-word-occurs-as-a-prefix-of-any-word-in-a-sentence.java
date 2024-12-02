class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        List<String> wordsList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (char character : sentence.toCharArray()) {
            if (character != ' ') {
                currentWord.append(character);
            } else {
                if (currentWord.length() > 0) {
                    wordsList.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            }
        }
        if (currentWord.length() > 0) {
            wordsList.add(currentWord.toString());
        }

        for (int wordIndex = 0; wordIndex < wordsList.size(); ++wordIndex) {
            String word = wordsList.get(wordIndex);
            if (word.length() >= searchWord.length()) {
                boolean isMatch = true;
                for (
                        int charIndex = 0;
                        charIndex < searchWord.length();
                        ++charIndex
                ) {
                    if (
                            word.charAt(charIndex) != searchWord.charAt(charIndex)
                    ) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return wordIndex + 1;
                }
            }
        }
        return -1;
    }
}