class Solution {
    public int[][] generateMatrix(int n) {
        int i = 0, j = 0;
        int[][] result = new int[n][n];
        int curr = 1;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up
        do {
            result[i][j] = curr;
            curr++;
            switch (dir) {
                case 0:
                    if ((j < n - 1) && (result[i][j + 1] == 0)) {
                        j++;
                    } else {
                        dir = (dir + 1) % 4;
                        i++;
                    }
                    break;
                case 1:
                    if ((i < n - 1) && (result[i + 1][j] == 0)) {
                        i++;
                    } else {
                        dir = (dir + 1) % 4;
                        j--;
                    }
                    break;
                case 2:
                    if ((j > 0) && (result[i][j - 1] == 0)) {
                        j--;
                    } else {
                        dir = (dir + 1) % 4;
                        i--;
                    }
                    break;
                case 3:
                    if ((i > 0) && (result[i - 1][j] == 0)) {
                        i--;
                    } else {
                        dir = 0;
                        j++;
                    }
                    break;
            }
        } while (curr <= n * n);
        return result;
    }
}