import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;

        int[] answer = Arrays.copyOf(num_list, len + 1);

        int last = num_list[len - 1];
        int beforeLast = num_list[len - 2];

        if (last > beforeLast) {
            answer[len] = last - beforeLast;
        } else {
            answer[len] = last * 2;
        }

        return answer;
    }
}