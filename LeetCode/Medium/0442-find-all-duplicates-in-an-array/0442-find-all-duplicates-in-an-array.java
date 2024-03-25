class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        if (n <= 1) return answer;

        boolean[] visit = new boolean[(int) Math.pow(10, 5)];

        for (int num : nums) {
            if (visit[num]) answer.add(num);
            else visit[num] = true;
        }
        return answer;
    }
}