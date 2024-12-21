class Solution {

    public int maxKDivisibleComponents(
            int n,
            int[][] edges,
            int[] values,
            int k
    ) {
        if (n < 2) return 1;

        int componentCount = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            graph.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }

        long[] longValues = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            int neighborNode = -1;
            if (
                    graph.get(currentNode) != null &&
                            !graph.get(currentNode).isEmpty()
            ) {
                neighborNode = graph.get(currentNode).iterator().next();
            }

            if (neighborNode >= 0) {
                graph.get(neighborNode).remove(currentNode);
                graph.get(currentNode).remove(neighborNode);
            }

            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else if (neighborNode >= 0) {
                longValues[neighborNode] += longValues[currentNode];
            }
            
            if (
                    neighborNode >= 0 &&
                            graph.get(neighborNode) != null &&
                            graph.get(neighborNode).size() == 1
            ) {
                queue.add(neighborNode);
            }
        }

        return componentCount;
    }
}