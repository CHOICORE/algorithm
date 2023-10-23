import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.stream(participant)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Arrays.stream(completion).forEach(c -> participantMap.put(c, participantMap.get(c) - 1));
        
        return participantMap
            .entrySet()
            .stream()
            .dropWhile(entry -> entry.getValue() < 1)
            .findFirst()
            .get()
            .getKey();
    }
}