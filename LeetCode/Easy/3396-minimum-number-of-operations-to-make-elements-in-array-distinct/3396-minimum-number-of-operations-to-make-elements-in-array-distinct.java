class Solution {
    public int minimumOperations(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i += 3, answer++) {
            if (checkUnique(nums, i)) {
                return answer;
            }
        }
        return answer;
    }

    private boolean checkUnique(int[] nums, int start) {
        Set<Integer> count = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (count.contains(nums[i])) {
                return false;
            }
            count.add(nums[i]);
        }
        return true;
    }
}