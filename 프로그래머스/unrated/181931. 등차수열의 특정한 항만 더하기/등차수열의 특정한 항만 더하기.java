class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int size = included.length;
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = a + d * i;
        }
        
        for (int i = 0; i < size; i++) {
            if (included[i]) {
                answer += arr[i];
            }
        }
        
        return answer;
    }
}