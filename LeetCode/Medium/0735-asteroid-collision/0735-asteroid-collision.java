class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int index = 0;

        for (int i = 0; i < asteroids.length; ++i) {
            if (asteroids[i] > 0) {
                asteroids[index++] = asteroids[i];
            } else {
                boolean insert = true;
                while (index > 0) {
                    if (asteroids[index - 1] < 0) {
                        break;
                    }
                    int diff = asteroids[index - 1] + asteroids[i];
                    if (diff == 0) {
                        insert = false;
                        --index;
                        break;
                    } else if (diff > 0) {
                        insert = false;
                        break;
                    } else {
                        --index;
                    }
                }
                if (insert) {
                    asteroids[index++] = asteroids[i];
                }
                
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; ++i) {
            res[i] = asteroids[i];
        }
            
        return res;
    }
}