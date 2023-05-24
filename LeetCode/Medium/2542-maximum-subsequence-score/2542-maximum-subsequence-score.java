class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        long answer = 0;
        int length = nums1.length;

        if (k == 1) {
            for (int i = 0; i < length; i++) {
                long cur = (long) nums1[i] * nums2[i];
                answer = Math.max(answer, cur);
            }
            return answer;
        }

        int[][] arr = new int[length][];
        for (int i = 0; i < length; i++) {
            arr[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        Queue<Integer> q = new PriorityQueue<>();
        long sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            int num1 = arr[i][0];
            if (i <= length - k) {
                long cur = (sum + num1) * arr[i][1];
                answer = Math.max(answer, cur);
            }
            if (q.size() < k - 1) {
                q.add(num1);
                sum += num1;
            } else if (num1 > q.peek()) {
                sum -= q.poll();
                sum += num1;
                q.add(num1);
            }
        }
        return answer;
    }
}