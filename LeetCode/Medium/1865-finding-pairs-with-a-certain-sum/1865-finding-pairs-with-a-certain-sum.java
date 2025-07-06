class FindSumPairs {
    private int[] n;
    private int[] m;
    private Map<Integer, Integer> c;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.n = nums1;
        this.m = nums2;
        this.c = new HashMap<>();
        for (int num : nums2) {
            c.put(num, c.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = m[index];
        c.put(oldVal, c.get(oldVal) - 1);
        m[index] += val;
        c.put(m[index], c.getOrDefault(m[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : n) {
            int rest = tot - num;
            ans += c.getOrDefault(rest, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */