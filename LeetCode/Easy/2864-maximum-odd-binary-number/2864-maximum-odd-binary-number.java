class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        Arrays.sort(arr);

        int secondLast = len - 2;
        for (int i = 0; i < len / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[secondLast - i];
            arr[secondLast - i] = temp;
        }

        return new String(arr);
    }
}