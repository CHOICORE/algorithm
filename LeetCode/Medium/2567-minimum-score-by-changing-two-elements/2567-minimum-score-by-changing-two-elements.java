class Solution {
    public int minimizeSum(int[] nums) {
        int min0, min1, min2, max2, max1, max0;
        min0 = min1 = min2 = Integer.MAX_VALUE;
        max0 = max1 = max2 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min2)
                if (x < min1) {
                    min2 = min1;
                    if (x < min0) {
                        min1 = min0;
                        min0 = x;
                    } else
                        min1 = x;
                } else
                    min2 = x;
            if (x > max2)
                if (x > max1) {
                    max2 = max1;
                    if (x > max0) {
                        max1 = max0;
                        max0 = x;
                    } else
                        max1 = x;
                } else
                    max2 = x;
        }
        return Math.min(max0 - min2, Math.min(max1 - min1, max2 - min0));
    }
}