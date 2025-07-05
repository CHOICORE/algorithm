class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int r = -1;

        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                r = key;
            }
        }
        return r;
    }
}