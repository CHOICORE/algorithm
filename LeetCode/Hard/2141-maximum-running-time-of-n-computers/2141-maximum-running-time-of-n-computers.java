class Solution {
    public boolean isPossible(int[] batteries, int n, long shift) {
        long totalWork = n * shift;
        long currWork = 0;
        for (int battery : batteries) {
            if (battery >= shift) {
                currWork += shift;
            } else {
                currWork += battery;
            }
        }
        return currWork >= totalWork;
    }

    public long maxRunTime(int n, int[] batteries) {
        long si = 0;
        long ei = 0;
        long p_ans = 0;
        for (int battery : batteries) {
            si = Math.min(si, battery);
            ei += battery;
        }
        ei = ei / n;
        while (si <= ei) {
            long mid = si + (ei - si) / 2;
            if (isPossible(batteries, n, mid)) {
                p_ans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return p_ans;
    }
}