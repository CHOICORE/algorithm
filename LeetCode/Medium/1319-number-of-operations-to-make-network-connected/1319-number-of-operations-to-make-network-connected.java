class Solution {
    
    private int search(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = search(parent, parent[x]);
        }
        return parent[x];
    }
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            int pu = search(parent, u);
            int pv = search(parent, v);
            if (pu != pv) {
                parent[pu] = pv;
                count--;
            }
        }
        return count - 1;
    }
}
