class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int val : asteroids) {
            queue.addLast(val);
            boolean shouldBreak = false;

            while (queue.size() > 1 && !shouldBreak) {
                int last = queue.pollLast();
                int first = queue.pollLast();
                // collide
                if (first > 0 && last < 0) {
                    if (first == Math.abs(last))
                        shouldBreak = true;
                    else if (first > Math.abs(last)) {
                        queue.addLast(first);
                        shouldBreak = true;
                    } else
                        queue.addLast(last);
                } else {
                    queue.addLast(first);
                    queue.addLast(last);
                    shouldBreak = true;
                }
            }
        }

        int[] ans = new int[queue.size()];

        for (int i = 0; i < ans.length; i++)
            ans[i] = queue.pollFirst();

        return ans;
    }
}