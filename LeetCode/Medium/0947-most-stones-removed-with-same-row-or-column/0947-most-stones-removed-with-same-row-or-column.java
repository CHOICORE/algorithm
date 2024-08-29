class Solution {

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int i, j;
        int n = stones.length;
        for (i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        int m = maxRow + maxCol + 1;
        DisjointSet ds = new DisjointSet(m);
        int[] res = new int[m + 1];
        for (i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            ds.unionSet(row, col);
            res[row] = 1;
            res[col] = 1;
        }
        int com = 0;
        for (i = 0; i <= m; i++) {
            if (res[i] == 1) {
                if (ds.findUPar(i) == i) {
                    com++;
                }
            }
        }
        return n - com;
    }

    static class DisjointSet {

        int[] rank;
        int[] parent;

        public DisjointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        public int findUPar(int u) {
            if (parent[u] == u) {
                return u;
            }
            return parent[u] = findUPar(parent[u]);
        }

        public void unionSet(int u, int v) {
            u = findUPar(u);
            v = findUPar(v);
            if (rank[u] < rank[v]) {
                parent[u] = v;
            } else if (rank[v] < rank[u]) {
                parent[v] = u;
            } else {
                parent[v] = u;
                rank[u]++;
            }
        }
    }
}