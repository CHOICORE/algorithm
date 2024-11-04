class Solution {
    public String compressedString(String word) {
        StringBuilder compressed = new StringBuilder();
        int position = 0;
        while (position < word.length()) {
            int consecutiveCount = 0;

            char currentChar = word.charAt(position);

            while (
                    position < word.length() &&
                            consecutiveCount < 9 &&
                            word.charAt(position) == currentChar
            ) {
                consecutiveCount++;
                position++;
            }

            compressed.append(consecutiveCount).append(currentChar);
        }

        return compressed.toString();
    }
}