class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 시작 픽셀의 색상과 새로운 색상이 같은 경우 이미 변경된 것으로 판단하여 더 이상의 작업을 수행하지 않음
        if (image[sr][sc] == color) {
            return image;
        }
        
        int originalColor = image[sr][sc];
        fill(image, sr, sc, originalColor, color);
        return image;
    }
    
    private void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        // 유효한 인덱스인지 검사
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }
        
        // 방문한 픽셀인지, 색상이 맞는지 확인하여 작업할지 말지 결정
        if (image[row][col] != originalColor) {
            return;
        }
        
        // 현재 픽셀의 색상을 변경하고 4방향으로 재귀적으로 작업 수행
        image[row][col] = newColor;
        fill(image, row - 1, col, originalColor, newColor); // 위로
        fill(image, row + 1, col, originalColor, newColor); // 아래로
        fill(image, row, col - 1, originalColor, newColor); // 왼쪽으로
        fill(image, row, col + 1, originalColor, newColor); // 오른쪽으로
    }
}
