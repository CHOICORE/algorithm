class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int r = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k]) {
                        r = Math.min(r, k - i);
                        break;
                    }
                }
            }
        }

        return r == n + 1 ? -1 : r * 2;
    }
}