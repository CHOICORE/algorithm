class Solution {
    public String predictPartyVictory(String senate) {
        int rCount = 0, dCount = 0;
        int len = senate.length();
        boolean[] vote = new boolean[len];

        while (rCount < len && dCount < len) {
            for (int i = 0; i < len && rCount < len && dCount < len; i++) {
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

        if (rCount == len)
            return "Radiant";
        else
            return "Dire";
    }
}