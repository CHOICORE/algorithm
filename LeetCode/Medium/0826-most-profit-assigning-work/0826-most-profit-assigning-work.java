class Solution {

    private static int getNetProfit(int[] worker, List<int[]> jobProfile) {
        int netProfit = 0;
        for (int ability : worker) {
            int l = 0, r = jobProfile.size() - 1, jobProfit = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobProfile.get(mid)[0] <= ability) {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            netProfit += jobProfit;
        }
        return netProfit;
    }

    public int maxProfitAssignment(
            int[] difficulty,
            int[] profit,
            int[] worker
    ) {
        List<int[]> jobProfile = new ArrayList<>();
        jobProfile.add(new int[]{0, 0});
        for (int i = 0; i < difficulty.length; i++) {
            jobProfile.add(new int[]{difficulty[i], profit[i]});
        }

        jobProfile.sort(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.max(
                    jobProfile.get(i)[1],
                    jobProfile.get(i + 1)[1]
            );
        }

        return getNetProfit(worker, jobProfile);
    }
}