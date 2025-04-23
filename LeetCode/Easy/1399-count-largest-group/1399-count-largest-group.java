class Solution {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> bucket = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, i0 = i;
            while (i0 != 0) {
                key += i0 % 10;
                i0 /= 10;
            }
            bucket.put(key, bucket.getOrDefault(key, 0) + 1);
            max = Math.max(max, bucket.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> pair : bucket.entrySet()) {
            if (pair.getValue() == max) {
                ++count;
            }
        }
        return count;
    }
}