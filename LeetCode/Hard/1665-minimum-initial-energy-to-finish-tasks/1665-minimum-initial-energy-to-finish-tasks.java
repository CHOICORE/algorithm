class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
        int r = 0;
        for (int[] task : tasks) {
            r = Math.max(r + task[0], task[1]);
        }
        return r;
    }
}