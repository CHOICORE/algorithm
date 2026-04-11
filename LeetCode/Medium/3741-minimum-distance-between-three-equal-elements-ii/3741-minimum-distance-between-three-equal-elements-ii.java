class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Map<Integer, Integer> occur = new HashMap<>();
        int r = n + 1;

        for (int i = n - 1; i >= 0; i--) {
            if (occur.containsKey(nums[i])) {
                next[i] = occur.get(nums[i]);
            }
            occur.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int secondPos = next[i];
            if (secondPos != -1) {
                int thirdPos = next[secondPos];
                if (thirdPos != -1) {
                    r = Math.min(r, thirdPos - i);
                }
            }
        }

        return r == n + 1 ? -1 : r * 2;
    }
}