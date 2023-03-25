class Solution {
    public int solution(int a, int b) {
        int gcd = gcd(a, b); // a와 b의 최대공약수 구하기
        int denominator = (b / gcd); // 분모의 기약분수 구하기

        // 분모가 2와 5로만 소인수분해 가능한지 확인
        while (denominator % 2 == 0) {
            denominator /= 2;
        }
        while (denominator % 5 == 0) {
            denominator /= 5;
        }

        // 분모가 2와 5로만 소인수분해 가능하면 유한소수, 그렇지 않으면 무한소수
        return denominator == 1 ? 1 : 2;
    }

    // 최대공약수를 구하는 유클리드 호제법 메소드
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
