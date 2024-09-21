import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int complete = 100;

        Queue<Integer> taken = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            taken.add((complete - progresses[i] - 1) / speeds[i] + 1);
        }

        List<Integer> deploys = new ArrayList<>();
        while (!taken.isEmpty()) {
            int count = 1;
            int head = taken.poll();

            while (!taken.isEmpty() && taken.peek() <= head) {
                taken.poll();
                count++;
            }

            deploys.add(count);
        }
        
        return deploys
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();

    }
}