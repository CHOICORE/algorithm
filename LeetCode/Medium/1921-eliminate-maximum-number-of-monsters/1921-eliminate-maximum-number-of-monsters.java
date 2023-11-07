class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> heap = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            heap.add((double) dist[i] / speed[i]);
        }

        int result = 0;
        while (!heap.isEmpty()) {
            if (heap.remove() <= result) {
                break;
            }

            result++;
        }

        return result;
    }
}