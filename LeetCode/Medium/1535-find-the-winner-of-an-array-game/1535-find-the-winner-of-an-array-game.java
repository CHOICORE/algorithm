class Solution {
    public int getWinner(int[] arr, int k) {
        int win = 0;
        int element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > element) {
                win = 0;
                element = arr[i];
            }
            if (++win == k) {
                break;
            }
        }
        return element;
    }
}
