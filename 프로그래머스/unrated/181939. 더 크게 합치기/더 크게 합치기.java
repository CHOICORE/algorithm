class Solution {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        String sumA = strA + strB;
        String sumB = strB + strA;

        return Math.max(Integer.parseInt(sumA), Integer.parseInt(sumB));
    }
}