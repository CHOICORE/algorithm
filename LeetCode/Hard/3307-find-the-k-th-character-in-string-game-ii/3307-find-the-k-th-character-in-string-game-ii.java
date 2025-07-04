class Solution {
    public char kthCharacter(long k, int[] operations) {
        int r = 0;
        int t;
        while (k != 1) {
            t = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << t) == k) {
                t--;
            }
            k = k - (1L << t);
            if (operations[t] != 0) {
                r++;
            }
        }
        return (char) ('a' + (r % 26));
    }
}