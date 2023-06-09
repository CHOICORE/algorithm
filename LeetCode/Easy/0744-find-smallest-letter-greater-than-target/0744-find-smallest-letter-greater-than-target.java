class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int i = 0;
        int j = letters.length - 1;

        int mid;

        if (letters[j] <= target) {
            return letters[i];
        }

        while (i <= j) {

            mid = i + (j - i) / 2;

            if (letters[mid] <= target) {
                i = mid + 1;
            }


            if (letters[mid] > target) {
                j = mid - 1;
            }
        }

        return letters[i];

    }
}