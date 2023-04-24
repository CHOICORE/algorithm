class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for(int i =0;i<grid[0].length;i++){
            result[i] = dropBall(i, grid);
        }

        return result;
    }

    private int dropBall(int startPoint, int[][] grid){
        int j = startPoint;
        for(int i=0;i<grid.length;i++){
            if(j<0 || j == grid[0].length){
                return -1;
            }
            if(grid[i][j] == 1){
                if(j == grid[0].length -1 || grid[i][j+1] == -1){
                    return -1;
                }
                j++;
            } else{
                if(j == 0 || grid[i][j-1] == 1){
                    return -1;
                }
                j--;
            }
        }

        return j;

    }
}