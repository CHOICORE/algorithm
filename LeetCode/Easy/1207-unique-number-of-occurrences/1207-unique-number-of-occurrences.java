class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] numberOfOccurrences = new int[2_001];
        boolean[] used = new boolean[1_001];

        for (int i : arr) {
            numberOfOccurrences[1_000 + i]++;
        }

        for (int i : arr) {
            int count = numberOfOccurrences[1_000 + i];
            numberOfOccurrences[1_000 + i] = 0;
            if (count > 0) {
                if (used[count]) return false;
                else used[count] = true;
            }
        }
        return true;
    }
}