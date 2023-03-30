class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int count = p.length();
        while (right < s.length()) {
            char curr = s.charAt(right++);
            if (frequencyMap.containsKey(curr)) {
                int freq = frequencyMap.get(curr);
                if (freq > 0) {
                    count--;
                }
                frequencyMap.put(curr, freq - 1);
            }
            if (count == 0) {
                result.add(left);
            }
            if (right - left == p.length()) {
                char prev = s.charAt(left++);
                if (frequencyMap.containsKey(prev)) {
                    int freq = frequencyMap.get(prev);
                    if (freq >= 0) {
                        count++;
                    }
                    frequencyMap.put(prev, freq + 1);
                }
            }
        }
        return result;
    }
}
