class Solution {
    private int search(int i, int[] route) {
        return route[i] == i ? i : (route[i] = search(route[i], route));
    }

    public int minScore(int n, int[][] roads) {
        int[] route = IntStream.rangeClosed(0, n).toArray();
        int[] answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int[] road : roads) {
            int start = search(road[0], route);
            int end = search(road[1], route);
            route[start] = end;
            answer[start] = Math.min(road[2], Math.min(answer[start], answer[end]));
            answer[end] = answer[start];
        }

        return answer[search(1, route)];
    }
}