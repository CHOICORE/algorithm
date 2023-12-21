class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] list = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            list[i] = points[i][0];
        }

        Arrays.sort(list);

        int max = Integer.MIN_VALUE;

        for (int i = list.length - 1; i > 0; i--) {
            int tmp = list[i] - list[i - 1];
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }
}