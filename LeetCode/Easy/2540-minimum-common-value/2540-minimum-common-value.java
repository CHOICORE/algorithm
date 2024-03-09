class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();

        for (int num : nums1) {
            tmp.add(num);
        }

        for (int num : nums2) {
            if (tmp.contains(num)) {
                return num;
            }
        }

        return -1;
    }
}