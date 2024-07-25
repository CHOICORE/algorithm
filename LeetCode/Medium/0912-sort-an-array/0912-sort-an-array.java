class Solution {
    public int[] sortArray(int[] nums) {
        int[] map = new int[100_001];
        for (int num : nums) {
            map[num + 50_000]++;
        }

        int k = 0;
        for (int i = 0; i < 100_001; i++) {
            for (var j = 0; j < map[i]; j++)
                nums[k++] = i - 50_000;
        }
        
        return nums;
    }
}