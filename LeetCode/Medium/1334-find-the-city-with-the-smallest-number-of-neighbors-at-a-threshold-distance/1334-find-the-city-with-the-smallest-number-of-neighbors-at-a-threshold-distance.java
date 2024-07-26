class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[2] <= t) {
                d[edge[0]][edge[1]] = edge[2];
                d[edge[1]][edge[0]] = edge[2];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (d[i][k] == Integer.MAX_VALUE)
                    continue;
                for (int j = i; j < n; j++) {
                    if (d[k][j] < Integer.MAX_VALUE && d[i][j] > (d[i][k] + d[k][j])) {
                        d[i][j] = d[j][i] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        int count = n;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] <= t) {
                    c++;
                }
            }
            if (c <= count) {
                count = c;
                answer = i;
            }
        }
        return answer;
    }
}