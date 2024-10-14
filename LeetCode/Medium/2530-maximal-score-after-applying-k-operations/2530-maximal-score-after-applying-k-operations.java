class Solution {
    public long maxKelements(int[] nums, int k) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int i : nums) {
            pq.add(i);
        }

        while (k-- > 0) {
            int maxElement = pq.poll();
            answer += maxElement;
            pq.add((int) Math.ceil(maxElement / 3.0));
        }
        return answer;
    }
}