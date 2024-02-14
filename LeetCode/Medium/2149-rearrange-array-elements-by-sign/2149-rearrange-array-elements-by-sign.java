class Solution {
    public int[] rearrangeArray(int[] a) {
        int[] answer = new int[a.length];
        int positive = 0, negative = 1;
        for (int j : a) {
            if (j > 0) {
                answer[positive] = j;
                positive += 2;
            } else {
                answer[negative] = j;
                negative += 2;
            }
        }
        return answer;

    }
}