class Solution {
    private int m, n;
    private int[][] heights;
    private boolean[][] visitedP, visitedA;
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        visitedP = new boolean[m][n];
        visitedA = new boolean[m][n];

        // 탐색을 위한 큐
        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueA = new LinkedList<>();

        // 탐색을 위해 바다의 가장자리에 있는 좌표를 큐에 추가
        for (int i = 0; i < m; i++) {
            queueP.offer(new int[]{i, 0});
            queueA.offer(new int[]{i, n-1});
            visitedP[i][0] = true;
            visitedA[i][n-1] = true;
        }
        for (int i = 0; i < n; i++) {
            queueP.offer(new int[]{0, i});
            queueA.offer(new int[]{m-1, i});
            visitedP[0][i] = true;
            visitedA[m-1][i] = true;
        }

        // 큐를 이용한 BFS 탐색
        bfs(queueP, visitedP);
        bfs(queueA, visitedA);

        // 결과 리스트 생성
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                // 유효한 좌표인지, 아직 방문하지 않은 육지인지, 현재 위치보다 높이가 높은지 확인
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n 
                        || visited[newRow][newCol] || heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
