class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] frequencyMap = new int[26];
        for (char c : p.toCharArray()) {
            frequencyMap[c - 'a']++;
        }
        int left = 0, right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (frequencyMap[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                result.add(left);
            }
            if (right - left == p.length() && frequencyMap[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return result;
    }
}
