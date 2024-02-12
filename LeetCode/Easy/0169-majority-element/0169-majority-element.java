class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0, count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            } else {
                count--;
            }

            if (count < 1) {
                majority = num;
                count = 1;
            }
        }
        return majority;
    }
}