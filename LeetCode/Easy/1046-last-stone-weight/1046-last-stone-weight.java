class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(stones, n, i);
        }
        while (n > 1) {
            int stone1 = stones[0];
            stones[0] = stones[--n];
            stones[n] = stone1;
            heapify(stones, n, 0);
            int stone2 = stones[0];
            stones[0] = stones[--n];
            stones[n] = stone2;
            heapify(stones, n, 0);
            int diff = Math.abs(stone1 - stone2);
            if (diff > 0) {
                stones[n++] = diff;
                heapify(stones, n, n - 1);
            }
        }
        return n == 0 ? 0 : stones[0];
    }
    
    private void heapify(int[] stones, int n, int i) {
        int maxIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && stones[left] > stones[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && stones[right] > stones[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = stones[i];
            stones[i] = stones[maxIdx];
            stones[maxIdx] = temp;
            heapify(stones, n, maxIdx);
        }
    }
}
