class Solution {
    public int reductionOperations(int[] nums) {
        int[] freq = new int[50001];
        for (int num : nums) {
            freq[num]++;
        }
        int answer = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                answer += operations - freq[i];
            }
        }
        return answer;
    }
}
