class Solution {
    public int longestArithSeqLength(int[] a) {
        int i, n = a.length, j, ans = 0;
        for (i = -50; i <= 50; i++) {
            int max = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (j = 0; j < n; j++) {
                int val = a[j] - i;
                map.put(a[j], map.getOrDefault(val, 0) + 1);
            }
            for (Integer it : map.keySet())
                max = Math.max(max, map.get(it));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}