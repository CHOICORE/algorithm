class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long sum = 0;
        for (int num : batteries) {
            sum += num;
        }

        Arrays.sort(batteries);

        int i = batteries.length - 1;
        while (batteries[i] > sum / n) {
            sum -= batteries[i--];
            n--;
        }
        return sum / n;
    }
}