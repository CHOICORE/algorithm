class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot) less++;
            else if (num == pivot) equal++;
        }

        int[] ans = new int[nums.length];
        int l = 0;
        int e = less;
        int g = less + equal;
        for (int num : nums) {
            if (num < pivot) {
                ans[l] = num;
                l++;
            } else if (num > pivot) {
                ans[g] = num;
                g++;
            } else {
                ans[e] = num;
                e++;
            }
        }
        return ans;
    }
}