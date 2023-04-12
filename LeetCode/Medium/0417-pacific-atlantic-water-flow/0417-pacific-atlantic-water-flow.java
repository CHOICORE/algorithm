class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        
        int m = heights.length, n = heights[0].length;
        boolean[][] canReachPac = new boolean[m][n];
        boolean[][] canReachAtl = new boolean[m][n];
        
        // DFS from cells on Pacific coast
        for (int i = 0; i < m; i++) {
            dfs(heights, canReachPac, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, canReachPac, 0, j);
        }
        
        // DFS from cells on Atlantic coast
        for (int i = 0; i < m; i++) {
            dfs(heights, canReachAtl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, canReachAtl, m - 1, j);
        }
        
        // Add cells that can reach both coasts to result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPac[i][j] && canReachAtl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        int m = heights.length, n = heights[0].length;
        canReach[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !canReach[x][y] && heights[x][y] >= heights[i][j]) {
                dfs(heights, canReach, x, y);
            }
        }
    }
}
