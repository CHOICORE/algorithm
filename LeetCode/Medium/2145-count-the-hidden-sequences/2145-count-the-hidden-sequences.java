class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long start = 0, max = 0, min = 0;
        for (int diff : differences) {
            start += diff;
            max = Math.max(max, start);
            min = Math.min(min, start);
        }
        
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}