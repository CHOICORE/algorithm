class Solution {
    public int minSteps(int n) {
        int answer = 0;
        for (int i = 2; i * i <= n; ) {
            if (n % i == 0) {
                answer += i;
                n = n / i;
            } else {
                i++;
            }
        }
        if (n != 1) answer = answer + n;
        
        return answer;
    }
}