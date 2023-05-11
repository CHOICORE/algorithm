class UnionFind {
    int[] parent;
    int[] rank;
    int comp;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        comp = n;
    }

    int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);


        if (a == b)
            return false;
        else {
            comp--;
            if (rank[a] < rank[b])
                parent[a] = b;
            else if (rank[b] < rank[a])
                parent[b] = a;
            else {
                parent[a] = b;
                rank[b] += 1;
            }

            return true;
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0])
                    uf.union(i, j);
                else if (stones[i][1] == stones[j][1])
                    uf.union(i, j);
            }
        }
        
        return n - uf.comp;

    }
}