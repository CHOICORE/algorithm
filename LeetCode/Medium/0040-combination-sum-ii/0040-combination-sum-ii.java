import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<>() {
            List<List<Integer>> result = null;

            public List<Integer> get(int i) {
                init();
                return result.get(i);
            }

            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (result != null) return;

                Arrays.sort(candidates);
                
                Map<Integer, Integer> freqMap = new HashMap<>();
                for (int i : candidates) {
                    freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
                }

                List<int[]> freq = new ArrayList<>();
                freqMap.forEach((k, v) -> freq.add(new int[]{k, v}));

                Set<List<Integer>> set = new HashSet<>();
                impl(freq, 0, target, new ArrayList<>(), 0, set);
                result = new ArrayList<>(set);
            }
        };
    }

    private void impl(List<int[]> candidates, int start, int target, List<Integer> list, int sum, Set<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            int[] c = candidates.get(i);
            if (c[1] == 0) continue;
            if (sum + c[0] > target) continue;

            list.add(c[0]);
            c[1]--;

            impl(candidates, i, target, list, sum + c[0], result);

            list.remove(list.size() - 1);
            c[1]++;
        }
    }
}