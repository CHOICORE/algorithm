class Solution {
    public int minimumOneBitOperations(int n) {
        int[] bits = new int[32];

        bits[0] = 1;
        for (int i = 1; i <= 31; i++) {
            bits[i] = 2 * bits[i - 1] + 1;
        }

        boolean flag = true;
        int steps = 0;

        for (int i = 31; i >= 0; i--) {
            int bitSet = (n >> i) & 1;
            if (bitSet == 0) continue;
            if (flag) steps += bits[i];
            else steps -= bits[i];
            flag = !flag;
        }

        return steps;
    }
}
