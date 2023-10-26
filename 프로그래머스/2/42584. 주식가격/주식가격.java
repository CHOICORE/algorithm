import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size]; // 결과를 저장할 배열

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i; // 가격이 떨어지면 해당 기간을 저장하고 종료
                    break;
                }
            }
            if (answer[i] == 0) {
                answer[i] = size - i - 1; // 끝까지 가격이 떨어지지 않으면 남은 기간을 저장
            }
        }

        return answer;
    }
}