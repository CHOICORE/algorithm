class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] node = new int[arr.length + 1];
        int count = 0;
        int length = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                length++;
            } else {
                count++;
                node[length]++;
                length = 1;
            }
        }
        for (int i = 1; i < node.length; i++) {
            int remove = Math.min(k / i, node[i]);
            count -= remove;
            k -= remove * i;
        }
        return count;
    }
}