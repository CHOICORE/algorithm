class Solution {
    public int countSeniors(String[] details) {
        int seniors = 0;

        for (String detail : details) {
            int ten = detail.charAt(11) - '0';
            int one = detail.charAt(12) - '0';
            int age = ten * 10 + one;

            if (age > 60) {
                seniors++;
            }
        }

        return seniors;
    }
}