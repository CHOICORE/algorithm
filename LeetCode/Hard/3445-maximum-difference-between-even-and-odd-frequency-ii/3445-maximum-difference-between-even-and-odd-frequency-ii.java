class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int answer = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; ++right) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int l = getStatus(prev_a, prev_b);
                        best[l] = Math.min(
                                best[l],
                                prev_a - prev_b
                        );
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int r = getStatus(cnt_a, cnt_b);
                    if (best[r ^ 0b10] != Integer.MAX_VALUE) {
                        answer = Math.max(
                                answer,
                                cnt_a - cnt_b - best[r ^ 0b10]
                        );
                    }
                }
            }
        }
        return answer;
    }

    private int getStatus(int a, int b) {
        return ((a & 1) << 1) | (b & 1);
    }
}