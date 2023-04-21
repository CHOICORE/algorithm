class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids==null || asteroids.length<=1)
            return asteroids;
        
        Stack<Integer> astStack = new Stack<Integer>();
        boolean blows = false;
        for(int ast: asteroids)
        {   blows = false;
            while(!astStack.isEmpty() && ast< 0 && astStack.peek() > 0 && !blows)
            {
                if(-ast < astStack.peek())
                       blows = true;
                else
                    if(-ast == astStack.peek())
                    {
                        blows = true;
                        astStack.pop();
                    }
                else 
                    astStack.pop();
            }
            
            if(!blows)
                astStack.push(ast);
            
        }
        
        int[] result = new int[astStack.size()];
        for(int i=result.length-1 ; i>=0 ;i--)
        {
            result[i] = astStack.pop();
        }
        
        return result;
    }
}