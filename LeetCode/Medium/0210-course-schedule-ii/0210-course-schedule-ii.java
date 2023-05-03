class Solution {
    boolean hasCycle = false;
    boolean[] onPath;
    boolean[] visited;
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {

            traverse(graph, i);
            if (hasCycle == true) return new int[]{};
        }


        Collections.reverse(res);
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private void traverse(List<Integer>[] graph, int v) {

        if (onPath[v] == true) {
            hasCycle = true;
        }

        if (visited[v] == true || hasCycle == true) {
            return;
        }

        visited[v] = true;
        onPath[v] = true;
        for (int node : graph[v]) {
            traverse(graph, node);
        }
    
        res.add(v);
        onPath[v] = false;
    }


    private List<Integer>[] buildGraph(int n, int[][] arr) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] edge : arr) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}