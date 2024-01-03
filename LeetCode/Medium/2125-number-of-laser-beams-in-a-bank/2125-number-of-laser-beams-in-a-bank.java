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
        return s.chars()
                .map(c -> c - '0')
                .sum();
    }
}