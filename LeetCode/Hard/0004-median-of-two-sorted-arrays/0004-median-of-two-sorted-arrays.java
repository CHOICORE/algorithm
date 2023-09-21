class Solution {
    public static int[] sortArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] newArr = new int[nums1.length + nums2.length];
        int count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                newArr[count++] = nums2[j++];
            } else {
                newArr[count++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            newArr[count++] = nums1[i++];
        }
        while (j < nums2.length) {
            newArr[count++] = nums2[j++];
        }
        return newArr;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] arr = sortArray(nums1, nums2);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }
}
