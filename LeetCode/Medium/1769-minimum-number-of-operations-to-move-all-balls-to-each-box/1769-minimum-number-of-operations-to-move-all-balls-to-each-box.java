class Solution {
    public int[] minOperations(String boxes) {
        char[] ch = boxes.toCharArray();
        int i;
        int n = boxes.length();
        int right = 0;
        int left = 0;
        int ans = 0;
        for (i = 0; i < n; i++) {
            if (ch[i] == '1') {
                ans += i;
                right++;
            }

        }
        int[] answer = new int[n];
        answer[0] = ans;
        if (ch[0] == '1') {
            left++;
            right--;
        }
        for (i = 1; i < n; i++) {
            ans = ans - right;
            ans = ans + left;
            if (ch[i] == '1') {
                right--;
                left++;
            }
            answer[i] = ans;
        }

        return answer;
    }
}