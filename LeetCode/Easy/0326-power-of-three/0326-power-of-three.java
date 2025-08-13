class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOf3 = 1_162_261_467;
        return n > 0 && maxPowerOf3 % n == 0;
    }
}