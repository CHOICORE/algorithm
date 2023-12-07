class Solution {
    public int[] solution(int[] num_list, int n) {

        int size = num_list.length - n;
        int[] answer = new int[size + 1];

        for (int i = n; i <= num_list.length; i++) {
            answer[i - n] = num_list[i - 1];
        }

        return answer;
    }
}