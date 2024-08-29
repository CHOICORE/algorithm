class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (
                    stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]
                ) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.count;
    }
    
    private static class UnionFind {

        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            count = n;
        }
        
        int find(int node) {
            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }
        
        void union(int n1, int n2) {
            int root1 = find(n1);
            int root2 = find(n2);

            if (root1 == root2) {
                return;
            }
            
            count--;
            parent[root1] = root2;
        }
    }
}