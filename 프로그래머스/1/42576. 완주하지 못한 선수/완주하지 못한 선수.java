import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 선수 이름으로 그룹핑,
        Map<String, Long> participants = Arrays.stream(participant)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 완주한 선수 이름으로 계산,
        for (String key : completion) {
            participants.computeIfPresent(key, (k, v) -> {
                if (v == 1) return null;
                return --v;
            });
        }
        // 완주하지 못한 선수 이름 반환
        return participants.keySet().iterator().next();
    }
}