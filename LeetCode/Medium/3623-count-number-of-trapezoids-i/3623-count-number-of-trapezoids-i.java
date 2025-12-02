class Solution {
    public static final int MOD = (int) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> t = new HashMap<>();
        long r = 0;
        long s = 0;
        for (int[] point : points) {
            t.put(point[1], t.getOrDefault(point[1], 0) + 1);
        }
        for (int p : t.values()) {
            long edge = ((long) p * (p - 1)) / 2;
            r = (r + edge * s) % MOD;
            s = (s + edge) % MOD;
        }
        return (int) r;
    }
}