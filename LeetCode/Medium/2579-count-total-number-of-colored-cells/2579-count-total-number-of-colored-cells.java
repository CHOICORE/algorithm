class Solution {
    public long coloredCells(int n) {
        long i = 1;
        int addend = 4;

        while (--n > 0) {
            i += addend;
            addend += 4;
        }
        return i;
    }
}