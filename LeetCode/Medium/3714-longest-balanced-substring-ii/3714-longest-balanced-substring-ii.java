class Solution {
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int x = x(cs);
        int y = Math.max(y(cs, 'a', 'b'), Math.max(y(cs, 'b', 'c'), y(cs, 'a', 'c')));
        int z = z(cs);
        return Math.max(x, Math.max(y, z));
    }

    private int x(char[] s) {
        int r = 0;
        int i = 0, n = s.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            r = Math.max(r, j - i);
            i = j;
        }
        return r;
    }

    private int y(char[] s, char a, char b) {
        int r = 0;
        int i = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] != a && s[i] != b) {
                i++;
            }
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1);
            int d = 0;
            while (i < n && (s[i] == a || s[i] == b)) {
                d += (s[i] == a) ? 1 : -1;
                Integer prev = pos.get(d);
                if (prev != null) {
                    r = Math.max(r, i - prev);
                } else {
                    pos.put(d, i);
                }
                i++;
            }
        }
        return r;
    }

    private int z(char[] s) {
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(f(0, 0), -1);

        int[] cnt = new int[3];
        int r = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            ++cnt[c - 'a'];
            int x = cnt[0] - cnt[1];
            int y = cnt[1] - cnt[2];
            long k = f(x, y);

            Integer prev = pos.get(k);
            if (prev != null) {
                r = Math.max(r, i - prev);
            } else {
                pos.put(k, i);
            }
        }
        return r;
    }

    private long f(int x, int y) {
        return (long) (x + 100000) << 20 | (y + 100000);
    }
}