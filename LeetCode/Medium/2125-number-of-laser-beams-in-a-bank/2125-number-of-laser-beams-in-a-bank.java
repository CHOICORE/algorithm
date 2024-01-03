class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;

        for (String s : bank) {
            int cur = calculate(s);
            if (cur == 0) continue;
            total += cur * prev;
            prev = cur;
        }
        return total;
    }

    private int calculate(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c - '0';
        }
        return count;
    }
}