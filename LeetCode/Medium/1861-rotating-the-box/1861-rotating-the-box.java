class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            int pos = n - 1;
            for (int j = pos; j >= 0; j--) {
                switch (box[i][j]) {
                    case '#':
                        ans[j][m - 1 - i] = '.';
                        ans[pos][m - 1 - i] = '#';
                        pos -= 1;
                        break;
                    case '*':
                        ans[j][m - 1 - i] = '*';
                        pos = j - 1;
                        break;
                    default:
                        ans[j][m - 1 - i] = '.';
                        break;
                }
            }
            while (pos >= 0) {
                ans[pos--][m - 1 - i] = '.';
            }
        }
        return ans;
    }

    private void moveRight(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            int pos = box[i].length - 1;
            for (int j = pos; j >= 0; j--) {
                switch (box[i][j]) {
                    case '#':
                        box[i][j] = '.';
                        box[i][pos--] = '#';
                        break;
                    case '*':
                        pos = j - 1;
                        break;
                    default:
                        break;
                }
            }
            while (pos >= 0) {
                box[i][pos--] = '.';
            }
        }
    }

    private char[][] rotate(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - i - 1] = box[i][j];
            }
        }
        return ans;
    }
}