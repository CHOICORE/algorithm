import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        return Arrays.stream(queries).mapToInt(query -> IntStream.rangeClosed(query[0], query[1])
                .map(i -> arr[i])
                .filter(i -> i > query[2])
                .min().orElse(-1)).toArray();
    }
}