class Solution {
    public int longestSubarray(int[] nums, int limit) {
        MonotonicQueue win = new MonotonicQueue();
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            win.add(nums[right]);
            right++;


            while (win.getMax() - win.getMin() > limit) {
                win.remove(nums[left]);
                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}


class MonotonicQueue {
    LinkedList<Integer> maxQueue = new LinkedList<>();
    LinkedList<Integer> minQueue = new LinkedList<>();

    public void add(int x) {

        while (!maxQueue.isEmpty() && maxQueue.getLast() < x) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(x);


        while (!minQueue.isEmpty() && minQueue.getLast() > x) {
            minQueue.removeLast();
        }
        minQueue.addLast(x);
    }

    public int getMax() {
        return maxQueue.getFirst();
    }

    public int getMin() {
        return minQueue.getFirst();
    }

    public void remove(int x) {
        if (maxQueue.getFirst() == x) {
            maxQueue.removeFirst();
        }

        if (minQueue.getFirst() == x) {
            minQueue.removeFirst();
        }
    }

}