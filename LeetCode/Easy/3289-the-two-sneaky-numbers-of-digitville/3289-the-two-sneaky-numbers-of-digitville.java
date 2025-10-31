class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            int c = count.getOrDefault(x, 0) + 1;
            count.put(x, c);
            if (c == 2) {
                r.add(x);
            }
        }
        return r.stream().mapToInt(Integer::intValue).toArray();
    }
}