class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] p = new int[n + 1];

        for (int i = 1; i < n + 1; i++) p[i] = i;

        int[] result = {0, 0};

        for (int[] edge : edges) {
            int p1 = p[edge[0]];
            int p2 = p[edge[1]];

            while (p1 != p[p1]) {
                p1 = p[p1];
            }
            while (p2 != p[p2]) {
                p2 = p[p2];
            }
            
            if (p1 == p2) {
                result[0] = edge[0];
                result[1] = edge[1];
            } else {
                p[p2] = p1;
            }

        }
        
        return result;
    }
}