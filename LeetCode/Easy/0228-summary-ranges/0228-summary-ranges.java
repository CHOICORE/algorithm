class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int begin = 0;
        int end = 0;
        StringBuilder str = new StringBuilder();
        int tmp = 0;
        while (end < nums.length) {
            if (begin == end) {
                end++;
                str.append(nums[begin]);
                if (end >= nums.length) {
                    list.add(str.toString());
                    str.setLength(0);
                    break;
                }
            } else {
                tmp = nums[end];
                if (tmp - 1 == nums[end - 1]) {
                    end++;
                } else {
                    if (end - 1 == begin) {
                        list.add(str.toString());
                        str.setLength(0);
                        begin = end;
                    } else if (end - 1 != begin) {
                        str.append("->" + nums[end - 1]);
                        list.add(str.toString());
                        str.setLength(0);
                        begin = end;
                    }
                }
            }
        }

        if (str.length() != 0) {
            str.append("->").append(nums[end - 1]);
            list.add(str.toString());
        }


        return list;
    }
}