class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;

        int len = costs.length;
        if (2 * candidates > len - k || len == k) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                cost += costs[i];
            }
            return cost;
        }

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int l = 0, r = len - 1;

        for (int i = 0; i < candidates; i++) {
            left.add(costs[l++]);
            right.add(costs[r--]);
        }

        while (k-- > 0) {
            if (left.peek() <= right.peek()) {
                cost += left.poll();
                left.add(costs[l++]);
            } else {
                cost += right.poll();
                right.add(costs[r--]);
            }
        }

        return cost;
    }
}