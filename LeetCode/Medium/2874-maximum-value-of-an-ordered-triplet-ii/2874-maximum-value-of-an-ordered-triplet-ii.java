public class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], nums[i - 1]);
            r[n - 1 - i] = Math.max(r[n - i], nums[n - i]);
        }
        long answer = 0;
        for (int j = 1; j < n - 1; j++) {
            answer = Math.max(answer, (long) (l[j] - nums[j]) * r[j]);
        }
        return answer;
    }
}