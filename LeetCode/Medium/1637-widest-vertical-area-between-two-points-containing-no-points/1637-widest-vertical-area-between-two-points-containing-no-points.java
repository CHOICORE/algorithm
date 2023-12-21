class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i] - arr[i - 1];
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }
}