class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        int[] result = new int[length];

        Arrays.sort(deck);

        return everyOther(deck, result, 0, 0, false);
    }

    private int[] everyOther(int[] deck, int[] result, int i, int r, boolean skip) {
        int length = deck.length;

        if (i == length) {
            return result;
        }

        while (r < length) {
            if (result[r] == 0) {
                if (!skip) {
                    result[r] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            r++;
        }

        return everyOther(deck, result, i, 0, skip);
    }
}