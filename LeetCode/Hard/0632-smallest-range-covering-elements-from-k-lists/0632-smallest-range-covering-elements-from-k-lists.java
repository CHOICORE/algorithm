class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                merged.add(new int[]{num, i});
            }
        }

        merged.sort(Comparator.comparingInt(a -> a[0]));

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        for (int[] ints : merged) {
            freq.put(
                    ints[1],
                    freq.getOrDefault(ints[1], 0) + 1
            );
            if (freq.get(ints[1]) == 1) count++;

            while (count == nums.size()) {
                int curRange = ints[0] - merged.get(left)[0];
                if (curRange < rangeEnd - rangeStart) {
                    rangeStart = merged.get(left)[0];
                    rangeEnd = ints[0];
                }

                freq.put(
                        merged.get(left)[1],
                        freq.get(merged.get(left)[1]) - 1
                );
                if (freq.get(merged.get(left)[1]) == 0) count--;
                left++;
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}