class Solution {
    public int trap(int[] height) {
        int i = 0, left = height[0], answer = 0;
        int j = height.length - 1, right = height[j];
        while (i < j) {
            if (left <= right) {
                answer += (left - height[i]);
                i++;
                left = Math.max(left, height[i]);
            } else {
                answer += (right - height[j]);
                j--;
                right = Math.max(right, height[j]);
            }
        }
        
        return answer;

    }
}
