class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();
        
        for (int num : nums) {
            Map<Integer, Integer> fr = freqMap.getOrDefault(num % k, new TreeMap<>());
            fr.put(num, fr.getOrDefault(num, 0) + 1);
            freqMap.put(num % k, fr);
        }
        
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            ArrayList<Pair<Integer, Integer>> subsets = new ArrayList<Pair<Integer, Integer>>(
                    entry.getValue().entrySet().size());
            for (Map.Entry<Integer, Integer> subsetEntry : entry.getValue().entrySet()) {
                subsets.add(
                        new Pair<>(subsetEntry.getKey(), subsetEntry.getValue()));
            }
            totalCount *= countBeautifulSubsets(subsets, subsets.size(), k, 0);
        }

        return totalCount - 1;
    }

    private int countBeautifulSubsets(ArrayList<Pair<Integer, Integer>> subsets,
                                      int numSubsets, int difference, int i) {
        if (i == numSubsets) {
            return 1;
        }
        
        int skip = countBeautifulSubsets(subsets, numSubsets, difference, i + 1);
        int take = (1 << subsets.get(i).getValue()) - 1;
        
        if (i + 1 < numSubsets &&
                subsets.get(i + 1).getKey() - subsets.get(i).getKey() == difference) {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 2);
        } else {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 1);
        }

        return skip + take;
    }
}