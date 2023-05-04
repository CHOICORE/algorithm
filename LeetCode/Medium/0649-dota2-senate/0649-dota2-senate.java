class Solution {
    public String predictPartyVictory(String senate) {
        int rCount = 0, dCount = 0;
        boolean[] vote = new boolean[senate.length()];

        while (rCount < senate.length() && dCount < senate.length()) {
            for (int i = 0; i < senate.length() && rCount < senate.length() && dCount < senate.length(); i++) {
                // this voter has been banned already.
                if (vote[i])
                    continue;

                if (senate.charAt(i) == 'R') {
                    if (rCount < dCount) vote[i] = true;
                    rCount++;
                } else {
                    if (dCount < rCount) vote[i] = true;
                    dCount++;
                }
            }
        }

        if (rCount == senate.length())
            return "Radiant";
        else
            return "Dire";
    }
}