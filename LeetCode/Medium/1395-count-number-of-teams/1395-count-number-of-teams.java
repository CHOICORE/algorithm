class Solution {
    public int numTeams(int[] rating) {
        int maxRating = 0;
        for (int r : rating) {
            maxRating = Math.max(maxRating, r);
        }

        int[] leftBIT = new int[maxRating + 1];
        int[] rightBIT = new int[maxRating + 1];

        for (int r : rating) {
            updateBIT(rightBIT, r, 1);
        }

        int teams = 0;
        for (int currentRating : rating) {
            updateBIT(rightBIT, currentRating, -1);

            int smallerRatingsLeft = getPrefixSum(leftBIT, currentRating - 1);
            int smallerRatingsRight = getPrefixSum(rightBIT, currentRating - 1);
            int largerRatingsLeft =
                    getPrefixSum(leftBIT, maxRating) -
                            getPrefixSum(leftBIT, currentRating);
            int largerRatingsRight =
                    getPrefixSum(rightBIT, maxRating) -
                            getPrefixSum(rightBIT, currentRating);

            teams += (smallerRatingsLeft * largerRatingsRight);
            teams += (largerRatingsLeft * smallerRatingsRight);

            updateBIT(leftBIT, currentRating, 1);
        }

        return teams;
    }

    private void updateBIT(int[] BIT, int index, int value) {
        while (index < BIT.length) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    private int getPrefixSum(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }
}