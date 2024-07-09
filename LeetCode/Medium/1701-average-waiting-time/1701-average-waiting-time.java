class Solution {
    public double averageWaitingTime(int[][] customers) {
        int nextIdleTime = 0;
        long netWaitTime = 0;

        for (int[] customer : customers) {
            nextIdleTime = Math.max(customer[0], nextIdleTime) + customer[1];
            netWaitTime += nextIdleTime - customer[0];
        }

        return (double) netWaitTime / customers.length;
    }
}