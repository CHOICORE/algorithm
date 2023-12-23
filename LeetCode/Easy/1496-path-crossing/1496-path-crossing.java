class Solution {
    int x = 0;
    int y = 0;

    public Solution() {
    }

    Solution(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Solution solution = (Solution) o;
        return x == solution.x && y == solution.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isPathCrossing(String path) {
        int n = 0, m = 0;
        Map<Solution, Boolean> map = new HashMap<>();
        Solution s = new Solution(0, 0);
        map.put(s, true);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                n++;
            } else if (c == 'S') {
                n--;
            } else if (c == 'E') {
                m++;
            } else {
                m--;
            }
            s = new Solution(m, n);
            if (map.get(s) != null) {
                return true;
            }
            map.put(s, true);
        }

        return false;
    }
}