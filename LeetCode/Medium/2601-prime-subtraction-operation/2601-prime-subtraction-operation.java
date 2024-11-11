class Solution {
    public boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        boolean[] sieve = new boolean[maxElement + 1];
        fill(sieve);
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            int difference = nums[i] - currValue;

            if (difference < 0) {
                return false;
            }

            if (sieve[difference] || difference == 0) {
                i++;
            }
            currValue++;
        }
        return true;
    }

    private int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void fill(boolean[] arr) {
        Arrays.fill(arr, true);
    }
}