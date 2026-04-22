class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> r = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int dis = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        dis++;
                    }
                }
                if (dis <= 2) {
                    r.add(query);
                    break;
                }
            }
        }
        return r;
    }
}