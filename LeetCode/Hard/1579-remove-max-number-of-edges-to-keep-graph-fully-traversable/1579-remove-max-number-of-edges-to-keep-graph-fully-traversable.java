class Solution {
    static final int
            TYPE = 0, U = 1, V = 2,
            ALICE = 1, BOB = 2, BOTH = 3;

    public int maxNumEdgesToRemove(
            final int n, final int[][] edges) {

        for (int i = 0, j = edges.length - 1; i < j; ) {
            if (edges[i][TYPE] == BOTH) {
                ++i;
                continue;
            }
            final var temp = edges[i];
            edges[i] = edges[j];
            edges[j] = temp;
            --j;
        }

        final UnionFind
                aliceUf = new UnionFind(n),
                bobUf = new UnionFind(n);
        int added = 0;

        for (final var edge : edges) {
            final int type = edge[TYPE];
            final int u = edge[U];
            final int v = edge[V];

            added += switch (type) {
                case BOTH -> aliceUf.union(u, v) | bobUf.union(u, v);
                case ALICE -> aliceUf.union(u, v);
                default -> bobUf.union(u, v);
            };

            if (aliceUf.isUnited() && bobUf.isUnited())
                return edges.length - added;
        }

        if (aliceUf.isUnited() && bobUf.isUnited())
            return edges.length - added;
        return -1;
    }
}

class UnionFind {
    final int[] parent;
    int groups;

    UnionFind(final int n) {
        parent = new int[n + 1];
        groups = n;
    }

    int union(final int u, final int v) {
        final int uParent = find(u);
        final int vParent = find(v);
        if (uParent == vParent)
            return 0;
        parent[uParent] = vParent;
        --groups;
        return 1;
    }

    int find(final int v) {
        if (parent[v] != 0)
            return parent[v] = find(parent[v]);
        return v;
    }

    boolean isUnited() {
        return groups == 1;
    }
}