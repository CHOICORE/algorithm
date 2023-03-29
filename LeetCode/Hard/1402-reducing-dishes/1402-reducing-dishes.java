class Solution {
    public int maxSatisfaction(int[] satisfaction) {
                
        Arrays.sort(satisfaction); 
                
        int maxLikeTime = 0, curLikeTime = 0, curTimeSum = 0;
        
        for (int i = satisfaction.length - 1; i >= 0; i--) { 
            curTimeSum += satisfaction[i]; 
            curLikeTime += curTimeSum; 
            maxLikeTime = Math.max(maxLikeTime, curLikeTime);
        }
        
        return maxLikeTime; 
    }
}
