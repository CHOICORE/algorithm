import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            // commands의 [0], [1] 인덱스로 부분 스트림을 자르고 정렬한 후 [2]의 크기만큼의 배열을 반환
            .mapToInt(command -> Arrays.stream(array, command[0] - 1, command[1])
                      .sorted()
//                      .peek(System.out::println)
                      .toArray()[command[2] - 1])
            .toArray();
    }
}