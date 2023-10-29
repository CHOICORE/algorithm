class Solution {
    public int solution(int[] numbers, int target) {
        return calculate(numbers, target, 0, 0);
    }

    private int calculate(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            return currentSum == target ? 1 : 0;
        }

        int positiveCount = calculate(numbers, target, index + 1, currentSum + numbers[index]);
        int negativeCount = calculate(numbers, target, index + 1, currentSum - numbers[index]);

        return positiveCount + negativeCount;
    }
}
