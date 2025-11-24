class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}