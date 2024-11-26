class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[1]]++;
        }

        int champ = -1;
        int champCount = 0;

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                champCount++;
                champ = i;
            }
        }

        return champCount > 1 ? -1 : champ;
    }
}