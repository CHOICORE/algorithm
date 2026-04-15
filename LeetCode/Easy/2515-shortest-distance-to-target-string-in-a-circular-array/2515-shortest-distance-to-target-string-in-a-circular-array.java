class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int r = words.length;
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                r = Math.min(r, Math.min(dist, n - dist));
            }
        }

        return r < n ? r : -1;
    }
}