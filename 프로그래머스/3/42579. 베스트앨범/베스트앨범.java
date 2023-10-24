import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        Map<String, List<Integer>> genreIndices = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genreIndices.computeIfAbsent(genre, k -> new ArrayList<>()).add(i);
        }

        List<Map.Entry<String, List<Integer>>> sortedGenres =
                genreIndices.entrySet().stream()
                        .sorted((a, b) ->
                                Integer.compare(
                                        b.getValue().stream().mapToInt(index -> plays[index]).sum(),
                                        a.getValue().stream().mapToInt(index -> plays[index]).sum()
                                )
                        ).collect(Collectors.toList());

        sortedGenres.forEach(entry ->
                entry.getValue().stream()
                        .sorted((a, b) -> Integer.compare(plays[b], plays[a]))
                        .limit(2)
                        .forEach(result::add)
        );

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}