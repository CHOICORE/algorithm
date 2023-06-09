class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int n = letters.length;
        int h = n - 1;
        char ans = letters[0];

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                ans = letters[mid];
                h = mid - 1;
            }
        }
        System.gc();
        return ans;
    }
}