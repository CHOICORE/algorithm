class Solution {
    public int solution(int angle) {
        int answer = 0;
        
        switch (angle) {
            case 180:
                answer = 4;
                break;
            case 90:
                answer = 2;
                break;
            default:
                if (0 < angle && angle < 90) {
                    answer = 1;
                } else if (90 < angle && angle < 180) {
                    answer = 3;
                }
        }
        return answer;
    }
}