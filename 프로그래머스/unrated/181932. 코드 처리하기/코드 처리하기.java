class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (c == '1') {
                mode = (mode == 0) ? 1 : 0;
            } else {
                if ((mode == 0 && i % 2 == 0) || (mode == 1 && i % 2 == 1)) {
                    answer.append(c);
                }
            }
        }

        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}