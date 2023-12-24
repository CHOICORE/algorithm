class Solution {
    public int minOperations(String s) {
        char zeroIndex = s.charAt(0);
        int count1 = count(s, zeroIndex);
        int count2 = count(s, zeroIndex == '0' ? '1' : '0') + 1;
        return Math.min(count1, count2);
    }

    private int count(String s, char prev) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == prev) {
                count++;
                prev = prev == '0' ? '1' : '0';
            } else {
                prev = current;
            }
        }
        return count;
    }
}