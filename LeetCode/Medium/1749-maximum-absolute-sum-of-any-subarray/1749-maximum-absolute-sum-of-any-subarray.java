class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = Integer.MAX_VALUE, maxPrefixSum = Integer.MIN_VALUE;
        int prefixSum = 0, maxAbsSum = 0;
        for (int num : nums) {
            prefixSum += num;

            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);

            if (prefixSum >= 0) {
                maxAbsSum = Math.max(
                        maxAbsSum,
                        Math.max(prefixSum, prefixSum - minPrefixSum)
                );
            } else {
                maxAbsSum = Math.max(
                        maxAbsSum,
                        Math.max(
                                Math.abs(prefixSum),
                                Math.abs(prefixSum - maxPrefixSum)
                        )
                );
            }
        }

        return maxAbsSum;
    }
}