class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        return switch (ineq + eq) {
            case "<=" -> n <= m ? 1 : 0;
            case ">=" -> n >= m ? 1 : 0;
            case "<!" -> n < m ? 1 : 0;
            case ">!" -> n > m ? 1 : 0;
            default -> 0;
        };
    }
}