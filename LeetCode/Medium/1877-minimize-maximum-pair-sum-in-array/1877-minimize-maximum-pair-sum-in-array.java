class Solution {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int l = 1;
        int r = max;
        int[] buc = new int[max + 1];
        for (int i : nums) {
            buc[i]++;
        }
        while (l <= r) {
            while (buc[l] == 0) {
                l++;
            }
            while (buc[r] == 0) {
                r--;
            }
            sum = Math.max(sum, l + r);

            if (buc[l] > buc[r]) {
                buc[l] = buc[l] - buc[r];
                r--;
            } else if (buc[l] < buc[r]) {
                buc[r] = buc[r] - buc[l];
                l++;
            } else {
                l++;
                r--;
            }
        }
        return sum;
    }
}