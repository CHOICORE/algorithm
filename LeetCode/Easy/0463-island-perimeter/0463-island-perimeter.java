class Solution {
    public int islandPerimeter(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int result = 0;

        for (int[] value : grid) {
            int prev = 0;
            for (int x = 0; x < width; x++) {
                int keep = value[x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }


        for (int x = 0; x < width; x++) {
            int prev = 0;
            for (int[] ints : grid) {
                int keep = ints[x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }
        return result;
    }
}