import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int answer = 0;
        int tmp = 0;
        while (tmp < nums.length) {
            int i = tmp;

            while (i < nums.length && nums[i] == nums[tmp]) {
                i++;
            }
            int count = i - tmp;
            if (count == 1) return -1;
            answer += count / 3;

            if (count % 3 != 0) answer++;
            tmp = i;
        }
        return answer;

    }
}