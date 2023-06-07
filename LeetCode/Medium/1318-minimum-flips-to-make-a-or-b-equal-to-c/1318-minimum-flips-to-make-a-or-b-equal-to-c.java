class Solution {
    public int minFlips(int a, int b, int c) {
        boolean[] A = getBits(a);
        boolean[] B = getBits(b);
        boolean[] C = getBits(c);
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((A[i] | B[i]) != C[i]) counter++;
            if ((A[i] & B[i]) && C[i] == false) counter++;
        }
        return counter;
    }

    private boolean[] getBits(int x) {
        boolean[] bits = new boolean[32];
        for (int i = 0; x != 0 && i < 32; i++) {
            bits[31 - i] = x % 2 == 1 ? true : false;
            x /= 2;
        }
        return bits;
    }
}