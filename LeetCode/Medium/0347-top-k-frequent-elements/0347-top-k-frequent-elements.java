class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> bucket[] = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<Integer>();
            bucket[frequency].add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (Integer integer : bucket[i]) {
                    ans[index++] = integer;
                }
            }
        }
        return ans;
    }
}