class Solution {
    public int minimumDeletions(String s) {
        char[] letters = s.toCharArray();
        int a = 0;
        int b = 0;
        int output = Integer.MAX_VALUE;
        for (char letter : letters) {
            a += ('b' - letter);
        }

        for (int i = 0; i < s.length(); i++) {
            output = Math.min(output, a + b);
            a -= ('b' - letters[i]);
            b += (letters[i] - 'a');
        }

        output = Math.min(output, a + b);
        return output;
    }
}