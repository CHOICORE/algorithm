class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            switch (diff) {
                case 1 -> answer.append("w");
                case -1 -> answer.append("s");
                case 10 -> answer.append("d");
                case -10 -> answer.append("a");
            }
        }

        return answer.toString();
    }
}
