class Solution {
    public int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int currProd = 1;

        for (int i = 0; i < arr.length; i++) {
            currProd *= arr[i];
            ans = Math.max(currProd, ans);
            if (currProd == 0) currProd = 1;
        }

        currProd = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            currProd *= arr[i];
            ans = Math.max(currProd, ans);
            if (currProd == 0) currProd = 1;
        }

        return ans;
    }
}