class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> r = new ArrayList<>();
        int n = s.length();
        int c = 0;

        while (c < n) {
            int end = Math.min(c + k, n);
            r.add(s.substring(c, end));
            c += k;
        }
        
        String last = r.get(r.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            r.set(r.size() - 1, last);
        }
        return r.toArray(new String[0]);
    }
}