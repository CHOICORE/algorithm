class Solution {
    public int countLargestGroup(int n) {
        int[] counts = new int[40];
        int answer = 0, mx = 0;
        for (int i = 1; i <= n; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            ++counts[s];
            if (mx < counts[s]) {
                mx = counts[s];
                answer = 1;
            } else if (mx == counts[s]) {
                ++answer;
            }
        }
        return answer;
    }
}