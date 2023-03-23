class Solution {
    public int longestPalindrome(String s) {
        int[] indexs = new int[128];
        for (char c : s.toCharArray()) {
            indexs[c]++;
        }
        int count = 0;
        for (int index : indexs) {
            count += index / 2 * 2;
            if (index % 2 == 1 && count % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
