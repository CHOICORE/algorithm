class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> l = new ArrayList<>();
        int[] res = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; ++i) {
            if (l.size() == 0 || obstacles[i] >= l.get(l.size() - 1)) {
                l.add(obstacles[i]);
                res[i] = l.size();
                continue;
            }
            int lo = 0, hi = l.size() - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (l.get(mid) > obstacles[i])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            l.set(lo, obstacles[i]);
            res[i] = lo + 1;
        }
        return res;
    }
}