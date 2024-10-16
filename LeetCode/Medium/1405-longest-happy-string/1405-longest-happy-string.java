class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int x = 0, y = 0, z = 0;
        int totalIterations = a + b + c;
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if (
                (a >= b && a >= c && x != 2) ||
                    (a > 0 && (y == 2 || z == 2))
            ) {
                answer.append('a');
                a--;
                x++;
                y = 0;
                z = 0;
            } else if (
                (b >= a && b >= c && y != 2) ||
                    (b > 0 && (z == 2 || x == 2))
            ) {
                answer.append('b');
                b--;
                y++;
                x = 0;
                z = 0;
            } else if (
                (c >= a && c >= b && z != 2) ||
                    (c > 0 && (x == 2 || y == 2))
            ) {
                answer.append('c');
                c--;
                z++;
                x = 0;
                y = 0;
            }
        }
        return answer.toString();
    }
}