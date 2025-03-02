class Solution {
    
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0;
        int j = 0;
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        while (i < nums1.length && j < nums2.length) {
            int[] ko = new int[2];

            if (nums1[i][0] == nums2[j][0]) {
                ko[0] = nums1[i][0];
                ko[1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ko[0] = nums1[i][0];
                ko[1] = nums1[i][1];

                i++;
            } else {
                ko[0] = nums2[j][0];
                ko[1] = nums2[j][1];

                j++;
            }

            arr.add(ko);
        }

        while (i < nums1.length) {
            arr.add(nums1[i++]);
        }
        while (j < nums2.length) {
            arr.add(nums2[j++]);
        }

        return arr.toArray(int[][]::new);
    }
}