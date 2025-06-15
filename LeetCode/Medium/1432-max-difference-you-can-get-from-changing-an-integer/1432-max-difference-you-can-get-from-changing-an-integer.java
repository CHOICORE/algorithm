class Solution {
    public int maxDiff(int num) {
        int min = num;
        int max = num;
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                String result = change(num, x, y);
                
                if (result.charAt(0) != '0') {
                    int r = Integer.parseInt(result);
                    min = Math.min(min, r);
                    max = Math.max(max, r);
                }
            }
        }

        return max - min;
    }

    public String change(int num, int x, int y) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            char digit = sb.charAt(i);
            if (digit - '0' == x) {
                sb.setCharAt(i, (char) ('0' + y));
            }
        }
        return sb.toString();
    }
}