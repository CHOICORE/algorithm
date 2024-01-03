class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, answer = 0;

        for (String s : bank) {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1') {
                    count++;
                }

            if (count > 0) {
                answer += prev * count;
                prev = count;
            }
        }

        return answer;
    }
}