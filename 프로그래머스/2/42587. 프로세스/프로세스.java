import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length - 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities) {
            queue.offer(priority);
        }

        Arrays.sort(priorities);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == priorities[size - answer]) {
                answer++;
                if (location == 0) break;
            } else {
                queue.offer(current);
                if (location == 0) location = queue.size();
            }

            location--;
        }

        return answer;
    }
}