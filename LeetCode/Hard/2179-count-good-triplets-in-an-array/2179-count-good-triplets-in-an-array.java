class FenwickTree {
    private final int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1];
    }

    public void update(int index, int delta) {
        index++;
        while (index < tree.length) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        index++;
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index -= index & -index;
        }
        return res;
    }
}

class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n], reversedIndexMapping = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos[nums1[i]]] = i;
        }
        FenwickTree tree = new FenwickTree(n);
        long res = 0;
        for (int value = 0; value < n; value++) {
            int p = reversedIndexMapping[value];
            int left = tree.query(p);
            tree.update(p, 1);
            int right = (n - 1 - p) - (value - left);
            res += (long) left * right;
        }
        return res;
    }
}