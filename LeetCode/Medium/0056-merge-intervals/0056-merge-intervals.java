class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] answer;
        List<int[]> tempAnswer = new ArrayList<>();
        int[] intervalEdges = new int[10000];
        int maxStartOfInterval = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            int startOfInterval = intervals[i][0];
            int endOfInterval = intervals[i][1];
            intervalEdges[startOfInterval] = Math.max(intervalEdges[startOfInterval], endOfInterval + 1);
        }
        int[] tempInterval = new int[]{-1, -1};
        for (int startOfCurrentInterval = 0; startOfCurrentInterval < intervalEdges.length; startOfCurrentInterval++) {
            
            int endOfTempInterval = tempInterval[1];
            int endOfCurrentInterval = intervalEdges[startOfCurrentInterval];
            if (endOfCurrentInterval != 0) {
                
                if (endOfTempInterval != -1) {
                    
                    if (startOfCurrentInterval <= endOfTempInterval) {
                        
                        endOfTempInterval = Math.max(endOfTempInterval, endOfCurrentInterval - 1);
                        tempInterval[1] = endOfTempInterval;
                        
                    } else {
                        
                        tempAnswer.add(tempInterval);
                        tempInterval = new int[]{
                                startOfCurrentInterval,
                                endOfCurrentInterval - 1
                                    
                        };
                    }
                } else {
                    
                    tempInterval[0] = startOfCurrentInterval;
                    tempInterval[1] = endOfCurrentInterval - 1;
                    
                }
            }
        }
        int endOfTempInterval = tempInterval[1];
        if (endOfTempInterval != -1) {
            
            tempAnswer.add(tempInterval);
            
        }
        answer = new int[tempAnswer.size()][];
        for (int i = 0; i < tempAnswer.size(); i++) {
            
            answer[i] = tempAnswer.get(i);
            
        }
        return answer;
    }
}