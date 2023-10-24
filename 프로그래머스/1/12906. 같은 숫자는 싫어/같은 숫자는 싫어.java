import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        // 이전 숫자 초기화
        int prev = -1;

        for (int num : arr) {
            // 이전에 본 숫자와 현재의 숫자가 다르면 리스트에 추가
            if (num != prev) {
                list.add(num);
            }
            // 현재의 숫자를 이전 숫자로 설정
            prev = num;
        }

        // 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}