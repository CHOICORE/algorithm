class Solution {
    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBallCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                totalSwaps += blackBallCount;
            } else {
                blackBallCount++;
            }
        }

        return totalSwaps;
    }
}