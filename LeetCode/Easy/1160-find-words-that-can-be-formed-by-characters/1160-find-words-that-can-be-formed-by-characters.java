class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            counts[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String s : words) {
            boolean result = true;
            int[] c = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int x = s.charAt(i) - 'a';
                c[x]++;
                if (c[x] > counts[x]) {
                    result = false;
                    break;
                }
            }
            if (result)
                res += s.length();
        }
        return res;
    }

}