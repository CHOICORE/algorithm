class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9 + 7;
        int[][] shortestPathMatrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], INF);
            shortestPathMatrix[i][i] = 0;
        }
        
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            shortestPathMatrix[start][end] = weight;
            shortestPathMatrix[end][start] = weight;
        }
        
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }
        
        return getCityWithFewestReachable(
                n,
                shortestPathMatrix,
                distanceThreshold
        );
    }
    
    void bellmanFord(
            int n,
            int[][] edges,
            int[] shortestPathDistances,
            int source
    ) {
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE);
        shortestPathDistances[source] = 0;
        
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                if (
                        shortestPathDistances[start] != Integer.MAX_VALUE &&
                                shortestPathDistances[start] + weight <
                                        shortestPathDistances[end]
                ) {
                    shortestPathDistances[end] = shortestPathDistances[start] +
                            weight;
                }
                if (
                        shortestPathDistances[end] != Integer.MAX_VALUE &&
                                shortestPathDistances[end] + weight <
                                        shortestPathDistances[start]
                ) {
                    shortestPathDistances[start] = shortestPathDistances[end] +
                            weight;
                }
            }
        }
    }
    
    int getCityWithFewestReachable(
            int n,
            int[][] shortestPathMatrix,
            int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;
        
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}