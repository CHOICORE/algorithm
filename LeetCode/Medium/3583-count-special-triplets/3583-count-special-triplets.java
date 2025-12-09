class Solution {
    static final int MOD = (int) (1e9 + 7);

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numPartialCnt = new HashMap<>();

        for (int v : nums) {
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        }

        long r = 0;
        for (int v : nums) {
            int target = v * 2;
            int lCnt = numPartialCnt.getOrDefault(target, 0);
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);
            int rCnt =
                    numCnt.getOrDefault(target, 0) -
                            numPartialCnt.getOrDefault(target, 0);
            r = (r + (long) lCnt * rCnt) % Solution.MOD;
        }

        return (int) r;
    }
}