class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        int begin = 0, end = 0;
        List<String> res = new ArrayList<>();
        
        while (end < nums.length) {
            while (end < nums.length - 1 && nums[end + 1] - nums[end] == 1) {
                ++end;
            }
            
            if (begin - end == 0) {
                res.add(String.format("%d", nums[begin]));
            } else {
                res.add(String.format("%d->%d", nums[begin], nums[end]));
            }
            ++end;
            begin = end;
        }
        return res;
    }
}