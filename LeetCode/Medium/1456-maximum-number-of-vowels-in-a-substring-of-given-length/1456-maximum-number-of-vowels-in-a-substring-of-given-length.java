class Solution {

    public static int maxVowels(String s, int k) {
        int length = s.length();
        int[] totalVowelCountByIndex = new int[length];

        int vowelCount = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
            totalVowelCountByIndex[i] = vowelCount;
        }

        int maxVowelCount = 0;
        for (int start = 0; start <= length - k; start++) {
            int end = start + k - 1;
            if (start == 0) {
                maxVowelCount = Math.max(maxVowelCount, totalVowelCountByIndex[end]);
            } else {
                maxVowelCount = Math.max(maxVowelCount, totalVowelCountByIndex[end] - totalVowelCountByIndex[start - 1]);
            }
        }

        return maxVowelCount;
    }
}