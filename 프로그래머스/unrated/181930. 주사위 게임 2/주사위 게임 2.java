class Solution {

    public int solution(int a, int b, int c) {
        int answer = 1;

        int count = getCount(a, b, c);

        for (int i = 1; i <= count; i++) {
            answer *= (pow(a, i) + pow(b, i) + pow(c, i));
        }

        return answer;
    }

    private int getCount(int a, int b, int c) {
        int count = 1;

        if (a == b && b == c) count++;

        if (a == b || a == c || b == c) count++;

        return count;
    }

    private int pow(int a, int b) {
        if (b == 0) return 1;
        return a * pow(a, b - 1);
    }
}