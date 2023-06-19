class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for (int j : gain) {
            sum += j;
            if (sum > max) {
                max = sum;
            }

        }
        return max;

    }
}