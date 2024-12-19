public class Solution {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();

        for (int j : arr) {
            if (monotonicStack.isEmpty() || j > monotonicStack.peek()) {
                monotonicStack.push(j);
            } else {
                int maxElement = monotonicStack.peek();
                while (
                        !monotonicStack.isEmpty() && j < monotonicStack.peek()
                ) {
                    monotonicStack.pop();
                }
                monotonicStack.push(maxElement);
            }
        }
        return monotonicStack.size();
    }
}