class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> numsArray = new ArrayList<>();
        int result = 0;

        for (int[] ints : grid) {
            for (int col = 0; col < grid[0].length; col++) {
                numsArray.add(ints[col]);
            }
        }

        Collections.sort(numsArray);

        int length = numsArray.size();
        int finalCommonNumber = numsArray.get(length / 2);

        for (int number : numsArray) {
            if (number % x != finalCommonNumber % x) {
                return -1;
            }
            result += Math.abs(finalCommonNumber - number) / x;
        }

        return result;
    }
}