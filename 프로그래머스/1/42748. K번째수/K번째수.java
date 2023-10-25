import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(command -> Arrays.stream(array, command[0] - 1, command[1])
                      .sorted()
                      .toArray()[command[2] - 1])
            .toArray();
    }
}