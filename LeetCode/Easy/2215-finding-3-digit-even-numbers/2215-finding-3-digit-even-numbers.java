class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        List<Integer> items = new ArrayList<>(nums);
        Collections.sort(items);
        int[] result = new int[items.size()];
        for (int i = 0; i < items.size(); ++i) {
            result[i] = items.get(i);
        }
        return result;
    }
}