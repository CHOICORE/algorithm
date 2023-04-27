class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks)
            map[task - 'A']++;

        int maxCount = 0, numOfMaxCount = 0;
        for (int num : map) {
            if (num > maxCount) {
                maxCount = num;
                numOfMaxCount = 1;
            } else if (num == maxCount) {
                numOfMaxCount++;
            }
        }

        int res = (n + 1) * (maxCount - 1) + numOfMaxCount;

        return Math.max(res, tasks.length);
    }
}