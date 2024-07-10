class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            depth += add(log, depth);
        }
        return depth;
    }

    int add(String log, int depth) {
        return log.charAt(1) == '.' ? depth == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 : 1;
    }
}