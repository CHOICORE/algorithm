class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int answer = 0;
        for (int i = 1; i < points.length; i++) {
            answer = Math.max(answer, points[i][0] - points[i - 1][0]);
        }

        return answer;
    }
}