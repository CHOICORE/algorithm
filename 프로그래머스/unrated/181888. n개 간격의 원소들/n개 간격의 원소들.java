import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new LinkedList<>();

        for (int i = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answer.add(num_list[i]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}