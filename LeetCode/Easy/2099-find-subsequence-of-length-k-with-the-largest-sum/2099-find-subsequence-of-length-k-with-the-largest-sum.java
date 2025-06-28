class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);

        Arrays.sort(sorted);

        int threshold = sorted[n - k];
        int thresholdCnt = 0;
        for (int i = n - k; i < n; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }

        int[] r = new int[k];

        int p = 0;
        for (int num : nums) {
            if (num > threshold) {
                r[p++] = num;
            } else if (num == threshold && thresholdCnt > 0) {
                r[p++] = num;
                thresholdCnt--;
            }
            if (p == k) {
                break;
            }
        }

        return r;
    }
}