class Solution {

    public static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> heapDict = new HashMap<>();
        heapDict.put(0, 0);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0});

        int mst_weight = 0;

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int w = top[0], u = top[1];

            if (visited[u] || heapDict.getOrDefault(u, Integer.MAX_VALUE) < w) continue;

            visited[u] = true;
            mst_weight += w;

            for (int v = 0; v < n; ++v) {
                if (!visited[v]) {
                    int new_distance = manhattanDistance(points[u], points[v]);
                    if (new_distance < heapDict.getOrDefault(v, Integer.MAX_VALUE)) {
                        heapDict.put(v, new_distance);
                        minHeap.add(new int[]{new_distance, v});
                    }
                }
            }
        }

        return mst_weight;
    }
}
