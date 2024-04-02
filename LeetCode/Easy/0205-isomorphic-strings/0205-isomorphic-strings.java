class Solution {
    public boolean isIsomorphic(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();
        if (s1 != s2) return false;
        Map<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < s1; i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if (!hm.containsKey(original)) {
                if (!hm.containsValue(replacement))
                    hm.put(original, replacement);
                else
                    return false;
            } else {
                char mapped = hm.get(original);
                if (mapped != replacement)
                    return false;
            }
        }
        return true;
    }
}