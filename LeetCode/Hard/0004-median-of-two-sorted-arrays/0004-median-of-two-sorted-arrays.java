class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int k = n / 2;

        if (n % 2 == 1) {
            return solve(nums1, nums2, k, 0, n1 - 1, 0, n2 - 1);
        } else {
            return (double) (solve(nums1, nums2, k, 0, n1 - 1, 0, n2 - 1)
                    + solve(nums1, nums2, k - 1, 0, n1 - 1, 0, n2 - 1)) / 2;
        }
    }

    public int solve(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {

        if (aStart > aEnd) {
            return b[k - aStart];
        }

        if (bStart > bEnd) {
            return a[k - bStart];
        }

        int aMid = aStart + (aEnd - aStart) / 2;
        int bMid = bStart + (bEnd - bStart) / 2;

        int a_value = a[aMid];
        int b_value = b[bMid];

        if (aMid + bMid < k) {
            if (a_value < b_value) {
                return solve(a, b, k, aMid + 1, aEnd, bStart, bEnd);
            } else {
                return solve(a, b, k, aStart, aEnd, bMid + 1, bEnd);
            }

        } else {
            if (a_value < b_value) {
                return solve(a, b, k, aStart, aEnd, bStart, bMid - 1);
            } else {
                return solve(a, b, k, aStart, aMid - 1, bStart, bEnd);
            }

        }
    }
}
