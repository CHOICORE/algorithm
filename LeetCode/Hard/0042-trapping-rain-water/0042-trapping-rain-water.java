class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, sum = 0, left = height[l], right = height[r];

        while (l < r) {
            if (left <= right) {
                sum += left - height[l];
                l++;
                left = Math.max(left, height[l]);
            } else {
                sum += right - height[r];
                r--;
                right = Math.max(right, height[r]);
            }
        }

        return sum;
    }
}