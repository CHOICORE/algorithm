class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        UnionFind DSU = new UnionFind(row * col + 2);
        int[][] arr = new int[row][col];
        for (int[] cell : cells) {
            arr[cell[0] - 1][cell[1] - 1] = 1;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) continue;
                int current = i * col + j;
                if (i == 0) DSU.union(current, row * col);
                else if (i == row - 1) DSU.union(current, row * col + 1);
                for (int k = 0; k < 4; k++) {
                    int newx = i + dirs[k][0];
                    int newy = j + dirs[k][1];
                    if (newx < 0 || newx >= row || newy < 0 || newy >= col || arr[newx][newy] == 1) continue;
                    int newnumber = newx * col + newy;
                    if (!DSU.connect(newnumber, current)) DSU.union(newnumber, current);
                }
            }
        }
        for (int i = cells.length - 1; i >= 0; i--) {
            int curx = cells[i][0] - 1;
            int cury = cells[i][1] - 1;
            int curnumber = curx * col + cury;
            if (curx == 0) DSU.union(col * row, curnumber);
            else if (curx == row - 1) DSU.union(col * row + 1, curnumber);
            if (DSU.connect(col * row, col * row + 1)) return i + 1;
            for (int k = 0; k < 4; k++) {
                int newx = curx + dirs[k][0];
                int newy = cury + dirs[k][1];
                if (newx < 0 || newx >= row || newy < 0 || newy >= col || arr[newx][newy] == 1) continue;
                int newnumber = newx * col + newy;
                if (!DSU.connect(newnumber, curnumber)) DSU.union(newnumber, curnumber);
            }
            arr[curx][cury] = 0;
        }
        return 0;
    }

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) return;
            if (size[rootx] > size[rooty]) {
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            } else {
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }
        }

        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }
    }
}