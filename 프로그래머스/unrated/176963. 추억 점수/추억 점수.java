import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int n = name.length;
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                if (yearningMap.containsKey(person)) {
                    sum += yearningMap.get(person);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
