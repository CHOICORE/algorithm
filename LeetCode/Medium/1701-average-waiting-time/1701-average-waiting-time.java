class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait = 0;
        int max = -1;
        for (int[] customer : customers) {
            max = Math.max(max, customer[0]);
            max += customer[1];
            wait += max - customer[0];
        }
        return wait / customers.length;
    }
}