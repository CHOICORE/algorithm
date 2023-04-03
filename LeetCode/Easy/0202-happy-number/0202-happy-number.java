class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        do {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        } while (!seen.contains(n) && seen.add(n));
        return false;
    }
}
