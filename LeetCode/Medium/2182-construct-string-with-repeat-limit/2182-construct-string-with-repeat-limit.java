class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int currentCharIndex = 25;
        while (currentCharIndex >= 0) {
            if (freq[currentCharIndex] == 0) {
                currentCharIndex--;
                continue;
            }

            int use = Math.min(freq[currentCharIndex], repeatLimit);
            result.append(String.valueOf((char) ('a' + currentCharIndex)).repeat(Math.max(0, use)));
            freq[currentCharIndex] -= use;

            if (freq[currentCharIndex] > 0) {
                int smallerCharIndex = currentCharIndex - 1;
                while (smallerCharIndex >= 0 && freq[smallerCharIndex] == 0) {
                    smallerCharIndex--;
                }
                if (smallerCharIndex < 0) {
                    break;
                }
                result.append((char) ('a' + smallerCharIndex));
                freq[smallerCharIndex]--;
            }
        }

        return result.toString();
    }
}