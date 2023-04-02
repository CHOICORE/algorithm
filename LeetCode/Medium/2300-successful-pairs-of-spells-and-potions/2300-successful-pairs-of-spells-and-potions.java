class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            int low = 0, high = potions.length - 1, pos = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    pos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (pos != -1) {
                pairs[i] = potions.length - pos;
            }
        }
        return pairs;
    }
}