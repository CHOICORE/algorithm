class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;

        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];

        for (int i = 1; i < len; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }

        int a = -coordinates[1][1];
        int b = coordinates[1][0];
        for (int i = 2; i < len; i++) {
            if (a * coordinates[i][0] + b * coordinates[i][1] != 0) {
                return false;
            }
        }
        return true;
    }
}