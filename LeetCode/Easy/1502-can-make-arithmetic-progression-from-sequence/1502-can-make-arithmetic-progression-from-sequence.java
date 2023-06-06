class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        int n = arr.length;

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        for (int num : arr) {
            if (minNumber > num)
                minNumber = num;
            if (maxNumber < num)
                maxNumber = num;
        }

        if ((maxNumber - minNumber) % (n - 1) != 0)
            return false;

        int difference = (maxNumber - minNumber) / (n - 1);

        int i = 0;

        while (i < n) {
            if (arr[i] == minNumber + difference * i)
                i++;
            else if ((arr[i] - minNumber) % difference != 0)
                return false;
            else {
                int pos = (arr[i] - minNumber) / difference;

                if (pos < i || arr[pos] == arr[i])
                    return false;

                int tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
            }
        }

        return true;
    }
}