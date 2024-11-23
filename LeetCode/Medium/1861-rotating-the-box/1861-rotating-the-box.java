class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[c][m - 1 - r] = box[r][c];
            }
        }

        for (int c = 0; c < m; c++) {
            for (int r = n - 1; r >= 0; r--) {
                if (res[r][c] == '#') {
                    int curRow = r;
                    while (curRow + 1 < n && res[curRow + 1][c] == '.') {
                        curRow++;
                    }
                    if (curRow != r) {
                        res[curRow][c] = '#';
                        res[r][c] = '.';
                    }
                }
            }
        }
        return res;
    }
}