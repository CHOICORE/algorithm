class Solution {
    public int countPairs(int[] nums, int k) {
        int l = nums.length;
        int answer = 0;
        for (int i = 0; i < l - 1; ++i) {
            for (int j = i + 1; j < l; ++j) {
                if ((i * j) % k == 0 && nums[i] == nums[j]) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}