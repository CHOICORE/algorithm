class Solution {
    int[] parent;
    boolean[] visited;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        c++;
        parent = new int[c];
        visited = new boolean[c];
        for (int i = 0; i < c; i++) parent[i] = i;

        for (int[] i : connections) {
            union(i[0], i[1]);
        }

        PriorityQueue<Integer>[] pq = new PriorityQueue[c];
        for (int i = 0; i < c; i++) {
            if (pq[find(i)] == null) {
                pq[find(i)] = new PriorityQueue<>();
            }
            pq[find(i)].add(i);
        }

        List<Integer> ls = new ArrayList<>();
        for (int[] i : queries) {
            if (i[0] == 2) {
                visited[i[1]] = true;
            } else {
                if (!visited[i[1]]) {
                    ls.add(i[1]);
                    continue;
                }
                boolean added = false;
                while (!pq[find(i[1])].isEmpty()) {
                    if (!visited[pq[find(i[1])].peek()]) {
                        added = true;
                        ls.add(pq[find(i[1])].peek());
                        break;
                    }
                    pq[find(i[1])].poll();
                }
                if (!added) ls.add(-1);
            }
        }

        int[] r = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) r[i] = ls.get(i);
        return r;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}