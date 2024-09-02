class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (final int j : chalk) {
            sum += j;
            if (sum > k) {
                break;
            }
        }
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
}