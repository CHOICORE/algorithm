class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var graph = graphBuild(equations, values);
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = bfs(graph, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private double bfs(HashMap<String, HashMap<String, Double>> graph, String start, String end) {
        if (!graph.containsKey(start)) {
            return -1;
        }
        ArrayDeque<Pair<String, Double>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(start, 1.0));
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            var poll = queue.poll();
            String pos = poll.getKey();
            Double weight = poll.getValue();
            if (pos.equals(end)) {
                return weight;
            }
            for (String neighbor : graph.get(pos).keySet()) {
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                queue.offer(new Pair<>(neighbor, graph.get(pos).get(neighbor) * weight));
            }
        }
        return -1;
    }

    private HashMap<String, HashMap<String, Double>> graphBuild(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }
        return graph;
    }
}