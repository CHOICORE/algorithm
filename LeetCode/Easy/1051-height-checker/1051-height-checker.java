class Solution {
    private void countingSort(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        
        for (int val : arr) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int index = 0;
        for (int val = min; val <= max; ++val) {
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
    }

    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone();
        countingSort(sortedHeights);

        int count = 0;
        for (int i = 0; i < sortedHeights.length; ++i) {
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        return count;
    }
}
