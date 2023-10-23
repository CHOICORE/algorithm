import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(cloth -> cloth[1], Collectors.counting()))
                .values()
                .stream()
                .reduce(1L, (a, b) -> a * (b + 1)).intValue() - 1;
    }
}