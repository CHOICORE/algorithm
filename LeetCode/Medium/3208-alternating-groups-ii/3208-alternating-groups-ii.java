public class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        System.arraycopy(colors, 0, extendedColors, 0, colors.length);
        if (k - 1 >= 0) System.arraycopy(colors, 0, extendedColors, colors.length + 0, k - 1);

        int length = extendedColors.length;
        int result = 0;
        int left = 0;
        int right = 1;

        while (right < length) {
            if (extendedColors[right] == extendedColors[right - 1]) {
                left = right;
                right++;
                continue;
            }

            right++;

            if (right - left < k) continue;

            result++;
            left++;
        }

        return result;
    }
}