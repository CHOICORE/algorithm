class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();

        for (int k : arr2) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == k) {
                    result.add(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }
        
        Arrays.sort(arr1);
        for (int j : arr1) {
            if (j != -1) {
                result.add(j);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}