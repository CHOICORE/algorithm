class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int max = Math.max(n1, n2);
        int in = 0, i = 0;
        String r = "";

        while (i < max || in > 0) {
            int A = 0;
            int B = 0;

            if (i < n1)
                A = a.charAt(n1 - 1 - i) - '0';

            if (i < n2)
                B = b.charAt(n2 - 1 - i) - '0';

            int S = (A ^ B) ^ in;
            int out = ((A ^ B) & in) | (A & B);

            r = (char) (S + '0') + r;
            in = out;

            i++;
        }

        return r;
    }
}
