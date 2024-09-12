class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;

        for (final String word : words) {
            boolean notContains = false;
            for (int j = 0; j < word.length(); j++) {
                if (!set.contains(word.charAt(j))) {
                    notContains = true;
                    break;
                }
            }
            if (!notContains) {
                count++;
            }
        }
        return count;
    }
}