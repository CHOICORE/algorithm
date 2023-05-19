class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Integer> groups = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!groups.containsKey(i) && !traverse(i, groups, 0, graph)) return false;
        }
        return true;
    }

    public boolean traverse(int curr, HashMap<Integer, Integer> assigned, int assign, int[][] graph) {
        if (assigned.containsKey(curr)) return assigned.get(curr) == assign;
        assigned.put(curr, assign);
        for (int neighbor : graph[curr]) {
            if (!traverse(neighbor, assigned, assign ^ 1, graph)) return false;
        }
        return true;
    }
}