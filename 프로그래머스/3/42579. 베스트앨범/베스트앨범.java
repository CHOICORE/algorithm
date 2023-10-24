import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        Map<String, List<Integer>> genreIndices = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!genreIndices.containsKey(genre)) {
                genreIndices.put(genre, new ArrayList<>());
            }
            genreIndices.get(genre).add(i);
        }

        List<Map.Entry<String, List<Integer>>> sortedGenres = new ArrayList<>(genreIndices.entrySet());
        sortedGenres.sort((a, b) -> {
            int sumA = a.getValue().stream().mapToInt(index -> plays[index]).sum();
            int sumB = b.getValue().stream().mapToInt(index -> plays[index]).sum();
            return Integer.compare(sumB, sumA);
        });

        for (Map.Entry<String, List<Integer>> entry : sortedGenres) {
            List<Integer> indices = entry.getValue();
            indices.sort((a, b) -> Integer.compare(plays[b], plays[a]));
            result.addAll(indices.subList(0, Math.min(2, indices.size())));
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}