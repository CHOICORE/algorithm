class Solution {
    private <T> void insertionSortReverseOrder(int[] main, T[] side, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (main[j + 1] > main[j]) {
                    int t = main[j + 1];
                    main[j + 1] = main[j];
                    main[j] = t;

                    T tT = side[j + 1];
                    side[j + 1] = side[j];
                    side[j] = tT;
                } else break;
            }
        }
    }

    private <T> void quickSortReverseOrder(int[] main, T[] side, int left, int right) {
        if (left >= right) return;
        if (right - left <= 11) {
            insertionSortReverseOrder(main, side, left, right);
            return;
        }
        int pivot;
        {
            int aV = main[left], bV = main[left + 1], cV = main[left + 2];
            if (aV <= bV && aV <= cV) {
                pivot = bV <= cV ? (left + 1) : (left + 2);
            } else if (bV <= aV && bV <= cV) {
                pivot = aV <= cV ? (left) : (left + 2);
            } else {
                pivot = aV <= bV ? (left) : (left + 1);
            }
        }

        int val = main[pivot];
        {
            main[pivot] = main[right];
            main[right] = val;
        }
        {
            T x = side[pivot];
            side[pivot] = side[right];
            side[right] = x;
        }
        int L = left, R = right - 1;
        while (true) {
            while (L <= R && main[L] >= val) L++;
            while (L <= R && main[R] <= val) R--;
            if (L < R) {
                swap(main, side, L, R);
                L++;
                R--;
            } else {
                break;
            }
        }
        swap(main, side, L, right);
        quickSortReverseOrder(main, side, left, L - 1);
        quickSortReverseOrder(main, side, L + 1, right);
    }

    private <T> void swap(int[] main, T[] side, int l, int r) {
        {
            int z = main[l];
            main[l] = main[r];
            main[r] = z;
        }
        {
            T z = side[l];
            side[l] = side[r];
            side[r] = z;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        quickSortReverseOrder(heights, names, 0, names.length - 1);
        return names;
    }
}