class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        Arrays.fill(temp, -1);
        for (int num : nums) {
            temp[num] = num;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == -1) return i;
        }
        return 0;
    }
}