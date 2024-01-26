class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom3 = denom1 * denom2;
        int numer3 = denom1 * numer2 + denom2 * numer1;
        for (int i = denom3; i >= 1; i--) {
            if (numer3 % i == 0 && denom3 % i == 0) {
                numer3 /= i;
                denom3 /= i;
            }
        }
        return new int[]{numer3, denom3};
    }
}