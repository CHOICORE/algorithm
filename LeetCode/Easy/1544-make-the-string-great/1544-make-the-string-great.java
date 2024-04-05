class Solution {
    public String makeGood(String s) {
        if (s.isEmpty() || s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();

        sb.append(s);

        int i = 0;

        while (i < sb.length() - 1) {
            char left = sb.charAt(i);
            char right = sb.charAt(i + 1);

            if (Math.abs(left - right) == 32) {
                sb.delete(i, i + 2);
                if (i > 0) i--;
            } else i++;
        }

        return sb.toString();
    }
}