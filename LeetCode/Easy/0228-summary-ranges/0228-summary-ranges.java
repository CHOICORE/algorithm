class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int begin = nums[i];
            while (i != n - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            int end = nums[i];
            if (begin == end) {
                res.add(String.valueOf(begin));
            } else
                res.add(begin + "->" + end);
        }
        return res;
    }
}