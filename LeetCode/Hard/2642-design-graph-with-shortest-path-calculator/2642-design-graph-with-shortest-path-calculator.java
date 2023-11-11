class Graph {
    int[][] distance;
    int n;
    final int MAX_VALUE = (int) 1e+9;

    public Graph(int n, int[][] edges) {
        this.n = n;
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = MAX_VALUE;
            }
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(
                            distance[i][j],
                            distance[i][k] + distance[k][j]
                    );
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        if (distance[edge[0]][edge[1]] <= edge[2]) {
            return;
        }
        distance[edge[0]][edge[1]] = edge[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Math.min(
                        distance[i][j],
                        distance[i][edge[0]] + edge[2] + distance[edge[1]][j]
                );
            }
        }
    }

    public int shortestPath(int n1, int n2) {
        if (distance[n1][n2] == MAX_VALUE) {
            return -1;
        }
        return distance[n1][n2];
    }
}