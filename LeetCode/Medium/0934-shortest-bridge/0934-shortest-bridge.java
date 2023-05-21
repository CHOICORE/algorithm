class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        List<int[]> bfsQueue = new ArrayList<>();
        dfs(grid, firstX, firstY, n, bfsQueue);

        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBFSQueue = new ArrayList<>();
            for (int[] pair : bfsQueue) {
                for (int[] dir : directions) {
                    int x = pair[0] + dir[0], y = pair[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return distance;
                        } else if (grid[x][y] == 0) {
                            int[] water = {x, y};
                            newBFSQueue.add(water);
                            grid[x][y] = -1;
                        }
                    }
                }
            }
            bfsQueue = newBFSQueue;
            distance++;
        }
        return distance;
    }

    private void dfs(int[][] grid, int x, int y, int n, List<int[]> bfsQueue) {
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x, y});
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                dfs(grid, newX, newY, n, bfsQueue);
            }
        }
    }
}