class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> r = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    r.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return r;
    }
}