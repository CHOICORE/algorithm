class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            String str = String.valueOf(n);
            for (char c : str.toCharArray()) {
                int digit = Character.getNumericValue(c);
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
