class Solution {
    public int[] solution(int[] num_list, int n) {
        double length = Math.ceil(num_list.length / (n * 1.0));

        int[] answer = new int[(int) length];

        for (int i = 0; i < length; i++) {
            answer[i] = num_list[i * n];
        }

        return answer;
    }
}