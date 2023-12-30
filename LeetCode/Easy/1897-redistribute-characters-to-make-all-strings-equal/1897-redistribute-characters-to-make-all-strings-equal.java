class Solution {
    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        int totalCharCount = 0;
        for (String s : words) {
            totalCharCount += s.length();
        }
        if (totalCharCount % words.length != 0) {
            return false;
        }

        int[] arr = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
            }
        }
        for (int i : arr) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
