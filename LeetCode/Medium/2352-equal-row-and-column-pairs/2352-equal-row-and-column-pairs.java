class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<Long, Integer> rcs = new HashMap<>();
        int same = 0;
        for (int i = 0; i < grid.length; i++) {
            long row = 0;
            for (int j = 0; j < grid[0].length; j++) {
                row = row * 10 + grid[i][j];
            }
            rcs.put(row, rcs.getOrDefault(row, 0) + 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            long col = 0;
            for (int i = 0; i < grid.length; i++) {
                col = col * 10 + grid[i][j];
            }
            same += rcs.getOrDefault(col, 0);
        }
        return same;
    }
}