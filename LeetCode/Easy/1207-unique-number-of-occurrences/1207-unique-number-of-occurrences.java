class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (final int j : arr) {
            if (hashMap.containsKey(j)) {
                hashMap.put(j, hashMap.get(j) + 1);
            } else {
                hashMap.put(j, 1);
            }
        }
        Set<Integer> hashSet = new HashSet<>();
        boolean flag = true;
        for (Map.Entry<Integer, Integer> mapElement : hashMap.entrySet()) {
            if (!hashSet.add(mapElement.getValue())) {
                flag = false;
            }
        }
        return flag;
    }
}