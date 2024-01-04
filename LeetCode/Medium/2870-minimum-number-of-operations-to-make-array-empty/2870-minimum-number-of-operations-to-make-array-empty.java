class Solution {
    public int minOperations(int[] nums) {
        var counter = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for (int c : counter.values()) {
            if (c == 1) {
                return -1;
            }
            answer += (int) Math.ceil((double) c / 3);
        }
        return answer;
    }
}