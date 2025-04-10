class Solution {
    public long numberOfPowerfulInt(
            long start,
            long finish,
            int limit,
            String s
    ) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = String.format("%" + n + "s", low).replace(' ', '0');
        long[] memo = new long[n];
        Arrays.fill(memo, -1);

        return dfs(0, true, true, low, high, limit, s, n - s.length(), memo);
    }

    private long dfs(
            int i,
            boolean maxLow,
            boolean maxHigh,
            String low,
            String high,
            int limit,
            String s,
            int previousLength,
            long[] memo
    ) {
        if (i == low.length()) {
            return 1;
        }
        if (!maxLow && !maxHigh && memo[i] != -1) {
            return memo[i];
        }

        int l = maxLow ? low.charAt(i) - '0' : 0;
        int h = maxHigh ? high.charAt(i) - '0' : 9;
        long res = 0;
        if (i < previousLength) {
            for (int digit = l; digit <= Math.min(h, limit); digit++) {
                res += dfs(
                        i + 1,
                        maxLow && digit == l,
                        maxHigh && digit == h,
                        low,
                        high,
                        limit,
                        s,
                        previousLength,
                        memo
                );
            }
        } else {
            int x = s.charAt(i - previousLength) - '0';
            if (l <= x && x <= Math.min(h, limit)) {
                res = dfs(
                        i + 1,
                        maxLow && x == l,
                        maxHigh && x == h,
                        low,
                        high,
                        limit,
                        s,
                        previousLength,
                        memo
                );
            }
        }
        if (!maxLow && !maxHigh) {
            memo[i] = res;
        }
        return res;
    }
}