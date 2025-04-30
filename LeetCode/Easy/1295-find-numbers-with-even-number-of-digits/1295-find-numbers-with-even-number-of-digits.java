class Solution {
    private boolean hasEvenDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return (count & 1) == 0;
    }

    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;

        for (int num : nums) {
            if (hasEvenDigits(num)) evenDigitCount++;
        }

        return evenDigitCount;
    }
}