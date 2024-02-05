class Solution {
    public int firstUniqChar(String s) {
        int answer = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                answer = Math.min(answer, index);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}