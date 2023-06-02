class Solution {
    public int maximumDetonation(int[][] bombs) {
        if (bombs == null || bombs.length == 0) return 0;
        List<List<Integer>> graph = new ArrayList<>();
        int len = bombs.length;
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<Integer>());
            build(i, bombs, graph);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dfs(i, graph, new boolean[len]));
            if (res == len) return res;
        }
        return res;
    }

    private int dfs(int start, List<List<Integer>> graph, boolean[] seen) {
        if (seen[start]) return 0;
        seen[start] = true;
        int count = 1;
        for (int next : graph.get(start)) {
            count += dfs(next, graph, seen);
        }
        return count;
    }

    private void build(int idx, int[][] bombs, List<List<Integer>> graph) {
        int x = bombs[idx][0];
        int y = bombs[idx][1];
        long r = bombs[idx][2];
        for (int i = 0; i < bombs.length; i++) {
            if (i == idx) continue;
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            if (dis(x1, y1, x, y) <= r * r) {
                graph.get(idx).add(i);
            }
        }
        return;
    }

    private long dis(int x2, int y2, int x1, int y1) {
        return (long) (x2 - x1) * (x2 - x1) + (long) (y2 - y1) * (y2 - y1);
    }
}