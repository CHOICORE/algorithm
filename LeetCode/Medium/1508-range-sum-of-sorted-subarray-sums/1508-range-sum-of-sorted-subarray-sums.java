import java.util.AbstractMap;
import java.util.Map;

class Solution {
    long largestSubArraySumPossible = 0, smallestSubArraySumPossible = 0;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) 1e9 + 7;
        long answer = 0;
        smallestSubArraySumPossible = nums[0];

        for (int i = 0; i < n; i++) {
            largestSubArraySumPossible += nums[i];
            smallestSubArraySumPossible = Math.min(smallestSubArraySumPossible, nums[i]);
        }

        answer = firstKSubarraysSum(nums, right) % mod;
        answer -= firstKSubarraysSum(nums, left - 1) % mod;

        return (int) (answer % mod);
    }

    public Map.Entry<Integer, Long> subArraysWithSumLessThanOrEqualTo(int[] nums, long target) {

        int countOfSuchSubArrays = 0;
        long totalSum = 0;
        long windowSum = 0;
        long currSum = 0;
        int n = nums.length;

        for (int left = 0, right = 0; right < n; ++right) {
            currSum += (long) nums[right] * (right - left + 1);
            windowSum += nums[right];
            while (windowSum > target) {
                currSum -= windowSum;
                windowSum -= nums[left++];
            }
            countOfSuchSubArrays += right - left + 1;
            totalSum += currSum;
        }
        return new AbstractMap.SimpleEntry<>(countOfSuchSubArrays, totalSum);
    }

    public long firstKSubarraysSum(int[] nums, int k) {
        long start = smallestSubArraySumPossible, end = largestSubArraySumPossible;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (subArraysWithSumLessThanOrEqualTo(nums, mid).getKey() < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        Map.Entry<Integer, Long> map = subArraysWithSumLessThanOrEqualTo(nums, start);
        long totalOfFirstKSubarraysSum = map.getValue();
        int countOfSuchSubArrs = map.getKey();
        return totalOfFirstKSubarraysSum - start * (countOfSuchSubArrs - k);
    }
}