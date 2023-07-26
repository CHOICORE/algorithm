class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = (int) 1e7, n = dist.length;

        if (n - 1 >= hour) return -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int i = 0; i < n - 1; i++) {
                hours += (dist[i] + mid - 1) / mid;
            }
            double hoursSpent = hours + (1d * dist[n - 1]) / mid;

            if (hoursSpent <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}