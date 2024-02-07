class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];

            answer[i] = -1;
            for (int j = s; j < e + 1; j++) {
                int digit = arr[j];
                if (k < digit) {
                    if (answer[i] == -1) {
                        answer[i] = digit;
                    } else {
                        answer[i] = Math.min(answer[i], digit);
                    }
                }
            }
        }

        return answer;
    }
}