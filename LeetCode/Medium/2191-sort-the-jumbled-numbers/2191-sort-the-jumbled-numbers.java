class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer[]> storePairs = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            String number = Integer.toString(nums[i]);
            StringBuilder formed = new StringBuilder();
            for (int j = 0; j < number.length(); ++j) {
                formed.append(mapping[number.charAt(j) - '0']);
            }
            int mappedValue = Integer.parseInt(formed.toString());
            storePairs.add(new Integer[]{mappedValue, i});
        }


        storePairs.sort(Comparator.comparing(o -> o[0]));

        int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }
        return answer;
    }
}