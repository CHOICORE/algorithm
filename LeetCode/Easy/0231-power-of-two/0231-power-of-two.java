class Solution {
    public boolean isPowerOfTwo(int n) {
        switch (n) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                if (n % 2 == 0) {
                    return isPowerOfTwo(n / 2);
                } else {
                    return false;
                }
        }
    }
}