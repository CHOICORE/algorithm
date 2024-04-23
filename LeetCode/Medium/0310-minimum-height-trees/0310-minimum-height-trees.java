class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] counts = new int[n];
        int[] links = new int[n];
        for (int[] edge : edges) {
            links[edge[0]] ^= edge[1];
            counts[edge[0]]++;
            links[edge[1]] ^= edge[0];
            counts[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] dists = new int[n];
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1)
                queue.add(i);
        }
        int stp = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int tmp = queue.poll();
                links[links[tmp]] ^= tmp;
                counts[links[tmp]]--;
                if (counts[links[tmp]] == 1) {
                    dists[links[tmp]] = Math.max(stp, dists[links[tmp]]);
                    queue.add(links[tmp]);
                }
            }
            stp++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dists[i], max);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dists[i] == max)
                answer.add(i);
        }
        return answer;
    }
}