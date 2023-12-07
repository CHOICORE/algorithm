class Solution {
    public int[] solution(int[] num_list, int n) {
        int length = num_list.length + 1 - n;
        int[] answer = new int[length];
        
        System.arraycopy(num_list, n - 1, answer, 0, length);
        
        return answer;
    }
}