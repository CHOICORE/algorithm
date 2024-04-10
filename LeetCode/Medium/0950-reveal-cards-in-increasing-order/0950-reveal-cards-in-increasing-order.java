class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        int[] result = new int[length];
        boolean skip = false;
        int i = 0;
        int r = 0;

        Arrays.sort(deck);

        while (i < length) {
            if (result[r] == 0) {
                
                if (!skip) {
                    result[r] = deck[i];
                    i++;
                }
                
                skip = !skip;
            }
            r = (r + 1) % length;
        }
        return result;
    }
}