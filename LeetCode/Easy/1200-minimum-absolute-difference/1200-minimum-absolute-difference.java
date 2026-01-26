class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] A) {
        Arrays.sort(A);
        
        int n = A.length;
        
        int minDiff = Integer.MAX_VALUE;
        
        List<List<Integer>> r = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = A[i] - A[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                r = new ArrayList<>();
                r.add(Arrays.asList(A[i - 1], A[i]));
            } else if (diff == minDiff) {
                r.add(Arrays.asList(A[i - 1], A[i]));
            }
        }

        return r;
    }
}
