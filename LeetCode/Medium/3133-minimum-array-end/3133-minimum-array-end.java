public class Solution {
    public long minEnd(int n, int x) {
        long result = 0, bit;
        --n;

        int[] binaryX = new int[64];
        int[] binaryN = new int[64];

        long longN = n;

        for (int i = 0; i < 64; ++i) {
            bit = ((long) x >> i) & 1;
            binaryX[i] = (int) bit;

            bit = (longN >> i) & 1;
            binaryN[i] = (int) bit;
        }

        int posX = 0, posN = 0;

        while (posX < 64) {
            while (binaryX[posX] != 0) {
                ++posX;
            }
            binaryX[posX] = binaryN[posN];
            ++posX;
            ++posN;
        }

        for (int i = 0; i < 64; ++i) {
            if (binaryX[i] == 1) {
                result += (long) Math.pow(2, i);
            }
        }

        return result;
    }
}