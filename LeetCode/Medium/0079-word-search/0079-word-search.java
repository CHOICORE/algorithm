class Solution {
    public boolean search(char[][] maze, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] != word.charAt(idx)) {
            return false;
        }

        maze[row][col] = '*';

        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};

        for (int i = 0; i < c.length; i++) {
            if (search(maze, word, row + r[i], col + c[i], idx + 1)) {
                return true;
            }
        }

        maze[row][col] = word.charAt(idx);
        return false;
    }

    public boolean exist(char[][] maze, String word) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == word.charAt(0)) {
                    if (search(maze, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
