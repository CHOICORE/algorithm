class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int frequency = 1;
        StringBuilder r = new StringBuilder();
        r.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                frequency++;
            } else {
                prev = s.charAt(i);
                frequency = 1;
            }
            if (frequency < 3) r.append(s.charAt(i));
        }
        return r.toString();
    }
}