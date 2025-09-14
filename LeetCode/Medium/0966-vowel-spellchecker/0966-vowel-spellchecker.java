class Solution {
    Set<String> perfects;
    Map<String, String> caps;
    Map<String, String> vowels;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        perfects = new HashSet();
        caps = new HashMap();
        vowels = new HashMap();

        for (String word : wordlist) {
            perfects.add(word);

            String lower = word.toLowerCase();
            caps.putIfAbsent(lower, word);

            String deVowel = deVowel(lower);
            vowels.putIfAbsent(deVowel, word);
        }

        String[] r = new String[queries.length];
        int i = 0;
        for (String query : queries)
            r[i++] = solve(query);
        return r;
    }

    public String solve(String query) {
        if (perfects.contains(query))
            return query;

        String lower = query.toLowerCase();
        if (caps.containsKey(lower))
            return caps.get(lower);

        String deVowel = deVowel(lower);
        if (vowels.containsKey(deVowel))
            return vowels.get(deVowel);

        return "";
    }

    public String deVowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}