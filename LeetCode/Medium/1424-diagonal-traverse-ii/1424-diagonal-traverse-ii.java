class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            List<Integer> list = nums.get(0);
            int[] a = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                a[i] = list.get(i);
            }
            return a;
        }
        int[] previousRow = new int[nums.size()];
        int size = 0;
        int max = 0;
        int i = 0;
        previousRow[0] = -1;
        for (List<Integer> num : nums) {
            size += num.size();
            max = Math.max(max, num.size());
            if (i > 0) {
                if (nums.get(i - 1).size() > 1) {
                    previousRow[i] = i - 1;
                } else {
                    previousRow[i] = previousRow[i - 1];
                }
            }
            i++;
        }

        int[] result = new int[size];
        int n = nums.size();
        int m = max;

        int idx = 0;
        result[idx++] = nums.get(0).get(0);

        for (int rowIdx = 1; rowIdx < n + m - 1; rowIdx++) {
            int r = rowIdx < n ? rowIdx : n - 1;
            int diff = rowIdx < n ? 0 : rowIdx + 1 - n;
            int c = diff;

            while (r >= 0 && c < m) {
                List<Integer> row = nums.get(r);
                if (row.size() > c) {
                    result[idx++] = row.get(c);
                }
                int key = previousRow[r];
                diff = r - key;
                r = key;
                c += diff;
            }
        }

        return result;
    }
}
