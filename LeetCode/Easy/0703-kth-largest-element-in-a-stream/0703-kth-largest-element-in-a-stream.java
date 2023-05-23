class KthLargest {
    private List<Integer> heap;
    private int k;

    KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new ArrayList<>(k);

        for (int n : nums)
            add(n);
    }

    private void siftdown(int i) {
        int n = heap.size();
        int left = (2 * i) + 1, right = (2 * i) + 2;
        while ((left < n && heap.get(i) > heap.get(left))
                || (right < n && heap.get(i) > heap.get(right))) {
            int smallest = right >= n || heap.get(left) < heap.get(right) ? left : right;
            Collections.swap(heap, i, smallest);
            i = smallest;
            left = (2 * i) + 1;
            right = (2 * i) + 2;
        }
    }

    private void siftup(int i) {
        int parent = (i - 1) / 2;
        while (i != 0 && heap.get(i) < heap.get(parent)) {
            Collections.swap(heap, i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    int peek() {
        return heap.get(0);
    }

    int poll() {
        Collections.swap(heap, 0, heap.size() - 1);
        int min = heap.remove(heap.size() - 1);
        siftdown(0);
        return min;
    }

    void offer(int val) {
        heap.add(val);
        siftup(heap.size() - 1);
    }

    public int add(int val) {
        if (k > heap.size())
            offer(val);
        else if (val > peek()) {
            poll();
            offer(val);
        }

        return peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */