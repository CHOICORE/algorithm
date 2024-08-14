class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;
        int maxElement = nums[arraySize - 1];

        int prefixCountSize = maxElement * 2;

        int[] prefixCount = new int[prefixCountSize];
        int[] valueCount = new int[maxElement + 1];

        int prefixIndex = 0;
        for (int value = 0; value < prefixCountSize; ++value) {
            while (prefixIndex < arraySize && nums[prefixIndex] <= value) {
                ++prefixIndex;
            }
            prefixCount[value] = prefixIndex;
        }
        for (int num : nums) {
            ++valueCount[num];
        }

        int left = 0;
        int right = maxElement;
        while (left < right) {
            int middle = (left + right) / 2;

            int count = countPairs(nums, prefixCount, valueCount, middle);

            if (count < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private int countPairs(
            int[] nums,
            int[] prefixCount,
            int[] valueCount,
            int maxDistance
    ) {
        int count = 0;
        int arraySize = nums.length;
        int index = 0;
        while (index < arraySize) {
            int currentValue = nums[index];
            int valueCountForCurrent = valueCount[currentValue];
            int pairsWithLargerValues =
                    prefixCount[Math.min(
                            currentValue + maxDistance,
                            prefixCount.length - 1
                    )] -
                            prefixCount[currentValue];
            int pairsWithSameValues =
                    (valueCountForCurrent * (valueCountForCurrent - 1)) / 2;
            count +=
                    pairsWithLargerValues * valueCountForCurrent + pairsWithSameValues;
            while (index + 1 < arraySize && nums[index] == nums[index + 1]) {
                ++index;
            }
            ++index;
        }
        return count;
    }
}