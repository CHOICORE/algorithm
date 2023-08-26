class Solution {
    public int findLongestChain(int[][] pairs) {
        final var N = pairs.length;

        final var P = new long[N];
        for (int i = 0; i < N; i++) {
            final long hi = ((long) pairs[i][1]) << 32;
            final long lo = 0xffff_ffffL & pairs[i][0];
            P[i] = hi | lo;
        }

        Arrays.sort(P);

        var size = 0;
        var lastEnd = Integer.MIN_VALUE;

        for (final var pair : P) {
            final var start = (int) pair;

            if (start > lastEnd) {
                size++;
                lastEnd = (int) (pair >>> 32);
            }
        }

        return size;
    }
}