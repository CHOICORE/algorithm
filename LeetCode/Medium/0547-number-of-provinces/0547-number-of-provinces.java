class Solution {
    int[][] isConnected;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        visited = new boolean[isConnected.length];
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                provinces++;
                visit(i);
            }
        }
        return provinces;
    }

    private void visit(int i) {
        int[] connections = isConnected[i];
        for (int j = 0; j < connections.length; j++) {
            if (connections[j] == 1 && !visited[j]) {
                visited[j] = true;
                visit(j);
            }
        }
    }
}