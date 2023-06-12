class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int begin = nums[0];
        StringBuilder sb = new StringBuilder();
        sb.append(begin);
        if (nums.length == 1) {
            res.add(sb.toString());
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            int len = String.valueOf(begin).length();
            if (nums[i] - nums[i - 1] == 1) {
                if (sb.length() == len) {
                    sb.append("->");
                    sb.append(nums[i]);
                } else {
                    sb.setLength(len + 2);
                    sb.append(nums[i]);
                }
            } else if (nums[i] - nums[i - 1] != 1) {
                res.add(sb.toString());
                sb.setLength(0);
                sb.append(nums[i]);
                begin = nums[i];
            }
            if (i == nums.length - 1) res.add(sb.toString());
        }
        return res;
    }
}