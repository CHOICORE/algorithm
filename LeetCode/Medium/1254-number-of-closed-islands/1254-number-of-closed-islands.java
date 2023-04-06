class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, visited, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {

        visited[i][j] = true;
        boolean isClosed = true;

        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            isClosed = false;
        }

        if (i > 0 && grid[i-1][j] == 0 && !visited[i-1][j]) {
            if (!dfs(grid, visited, i-1, j, m, n)) {
                isClosed = false;
            }
        }

        if (i < m - 1 && grid[i+1][j] == 0 && !visited[i+1][j]) {
            if (!dfs(grid, visited, i+1, j, m, n)) {
                isClosed = false;
            }
        }

        if (j > 0 && grid[i][j-1] == 0 && !visited[i][j-1]) {
            if (!dfs(grid, visited, i, j-1, m, n)) {
                isClosed = false;
            }
        }

        if (j < n - 1 && grid[i][j+1] == 0 && !visited[i][j+1]) {
            if (!dfs(grid, visited, i, j+1, m, n)) {
                isClosed = false;
            }
        }
        return isClosed;
    }
}