public class Solution {
    private static class DSU {
        int[] rank;
        int[] parent;

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findParent(int node) {
            if (parent[node] != node) {
                parent[node] = findParent(parent[node]);
            }
            return parent[node];
        }

        boolean union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            if (px == py) {
                return false;
            }
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                if (rank[px] == rank[py]) {
                    rank[py]++;
                }
            }
            return true;
        }
    }

    public long countPairs(int n, int[][] edges) {
        DSU d = new DSU(n);

        for (int[] e : edges) {
            d.union(e[0], e[1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int p = d.findParent(i);
            int cnt = map.getOrDefault(p, 0);
            ans += i - cnt;
            map.put(p, cnt + 1);
        }
        return ans;
    }
}
