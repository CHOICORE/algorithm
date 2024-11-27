class Solution {
    private int findMinDistance(
            List<List<Integer>> adjList,
            int n,
            int currentNode,
            int[] dp
    ) {

        if (currentNode == n - 1) return 0;


        if (dp[currentNode] != -1) return dp[currentNode];

        int minDistance = n;

        for (int neighbor : adjList.get(currentNode)) {

            minDistance = Math.min(
                    minDistance,
                    findMinDistance(adjList, n, neighbor, dp) + 1
            );
        }


        return dp[currentNode] = minDistance;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        List<List<Integer>> adjList = new ArrayList<>(n);


        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        List<Integer> answer = new ArrayList<>();


        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];


            adjList.get(u).add(v);


            answer.add(findMinDistance(adjList, n, 0, dp));


            Arrays.fill(dp, -1);
        }


        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
