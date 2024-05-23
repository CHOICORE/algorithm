class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);
        int r = 1, p, pp;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            if (m.containsKey(cur - k)) continue;

            p = 0;

            while (m.containsKey(cur)) {
                pp = p;
                p = ((1 << m.get(cur)) - 1) * r;
                r += pp;
                cur += k;
            }
            r += p;
        }
        return r - 1;
    }
}