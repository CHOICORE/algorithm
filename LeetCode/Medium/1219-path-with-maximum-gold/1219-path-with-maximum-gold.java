class Solution {
    private final int[] DIRECTIONS = new int[]{0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int totalGold = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                totalGold += cell;
            }
        }
        
        int maxGold = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    maxGold = Math.max(maxGold, bfsBacktrack(grid, rows, cols, row, col));
                    if (maxGold == totalGold) {
                        return totalGold;
                    }
                }
            }
        }
        return maxGold;
    }
    
    private int bfsBacktrack(int[][] grid, int rows, int cols, int row, int col) {
        Queue<Pair<int[], Set<String>>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int maxGold = 0;
        visited.add(row + "," + col);
        queue.offer(new Pair<>(new int[]{row, col, grid[row][col]}, visited));

        while (!queue.isEmpty()) {
            Pair<int[], Set<String>> current = queue.poll();
            int currRow = current.getKey()[0];
            int currCol = current.getKey()[1];
            int currGold = current.getKey()[2];
            Set<String> currVis = current.getValue();
            maxGold = Math.max(maxGold, currGold);
            
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = currRow + DIRECTIONS[direction];
                int nextCol = currCol + DIRECTIONS[direction + 1];
                
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols &&
                        grid[nextRow][nextCol] != 0 &&
                        !currVis.contains(nextRow + "," + nextCol)) {

                    currVis.add(nextRow + "," + nextCol);
                    Set<String> copyVis = new HashSet<>(currVis);
                    queue.offer(new Pair<>(new int[]{nextRow, nextCol,
                            currGold + grid[nextRow][nextCol]}, copyVis));
                    currVis.remove(nextRow + "," + nextCol);

                }
            }
        }
        return maxGold;
    }
}