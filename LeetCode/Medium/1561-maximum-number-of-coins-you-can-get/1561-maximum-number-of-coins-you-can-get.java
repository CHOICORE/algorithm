class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0, i = 0, j = piles.length - 1;
        while (i < j) {
            sum += piles[j - 1];
            j = j - 2;
            i++;
        }
        
        return sum;
    }
}
