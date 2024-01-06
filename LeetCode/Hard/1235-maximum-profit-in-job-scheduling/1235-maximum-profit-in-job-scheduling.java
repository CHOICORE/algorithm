import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int prevIndex = searchForIndex(jobs, i);
            int prevProfit = (prevIndex == -1) ? 0 : dp[prevIndex];

            dp[i] = Math.max(dp[i - 1], jobs[i].profit + prevProfit);
        }

        return dp[n - 1];
    }

    public int searchForIndex(Job[] jobs, int curIndex) {
        if (jobs[0].endTime > jobs[curIndex].startTime) {
            return -1;
        }

        int left = 0;
        int right = curIndex - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].endTime <= jobs[curIndex].startTime) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (jobs[right].endTime <= jobs[curIndex].startTime) {
            return right;
        }
        return left;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
