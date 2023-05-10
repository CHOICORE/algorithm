class Solution {
    public int[][] generateMatrix(int n) {
        int s = 1;
        int e = n * n;
        boolean rowTurn = true;
        boolean backward = false;
        int r = 0;
        int c = 0;
        int re = n;
        int ce = n;
        int[][] mat = new int[n][n];
        while (s <= e) {
            if (rowTurn) {
                if (!backward) {
                    for (; c < ce; c++) {
                        mat[r][c] = s++;
                    }
                    r++;
                    c--;
                } else {
                    for (; c >= n - ce; c--) {
                        mat[r][c] = s++;
                    }
                    r--;
                    c++;
                    re--;
                }
            } else {
                if (!backward) {
                    for (; r < re; r++) {
                        mat[r][c] = s++;
                    }
                    c--;
                    r--;

                } else {
                    for (; r >= n - re; r--) {
                        mat[r][c] = s++;
                    }
                    r++;
                    c++;
                    ce--;
                }

                backward = !backward;
            }

            rowTurn = !rowTurn;

        }

        return mat;
    }
}