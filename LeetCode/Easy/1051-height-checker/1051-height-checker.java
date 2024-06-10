class Solution {
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        if (n1 >= 0) System.arraycopy(arr, left, tempArr, left, n1);
        if (n2 >= 0) System.arraycopy(arr, start2, tempArr, start2, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[left + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[left + i];
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }
        
        while (i < n1) {
            arr[k] = tempArr[left + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }
    
    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        merge(arr, left, mid, right, tempArr);
    }

    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone();
        int[] tempArray = new int[heights.length];
        mergeSort(sortedHeights, 0, sortedHeights.length - 1, tempArray);

        int count = 0;
        for (int i = 0; i < sortedHeights.length; ++i) {
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        return count;
    }
}