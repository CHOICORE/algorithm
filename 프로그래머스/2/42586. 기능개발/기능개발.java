import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int complete = 100;

        Queue<Integer> taken = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            taken.add((complete - progress - 1) / speed + 1);
        }

        System.out.println(taken);

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