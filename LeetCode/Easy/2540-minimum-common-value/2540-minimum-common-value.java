class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0;
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        
        if (nums1[num1Length - 1] < nums2[0] || nums2[num2Length - 1] < nums1[0])
            return -1;

        while (i < num1Length && j < num2Length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }
}