import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10; // 일의 자리 수를 구해서 더함
            n /= 10; // 일의 자리 수를 버리고 다음 자리 수로 이동
        }

        return answer;
    }
}