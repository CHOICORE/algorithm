class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int l = arr.length;
        int[] counter = new int[l];

        for (final int j : arr) {
            ++counter[Math.min(j - 1, l - 1)];
        }
        int ans = 1;
        for (int i = 1; i < l; i++) {
            ans = Math.min(i + 1, ans + counter[i]);
        }

        return ans;
    }
}
