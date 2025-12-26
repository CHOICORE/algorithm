class Solution {
    public int bestClosingTime(String customers) {
        int max = 0;
        int score = 0;
        int best = 0;

        for (int i = 0; i < customers.length(); i++) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;

            if (score > max) {
                max = score;
                best = i + 1;
            }
        }
        return best;
    }
}