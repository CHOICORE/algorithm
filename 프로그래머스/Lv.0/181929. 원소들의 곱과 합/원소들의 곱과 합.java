import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        
        int answer = -1;

        int sum = Arrays.stream(num_list).sum();

        int multiply = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);

        if (multiply < sum * sum) {
            answer = 1;
        } else if (multiply > sum * sum) {
            answer = 0;
        }

        return answer;
    }
}