class Solution {
    public int maxDepth(String s) {
        int answer = 0;
        int temp = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {

                temp++;
            }
            if (i == ')') {
                temp--;
            }
            answer = Math.max(temp, answer);

        }
        
        return answer;
    }
}