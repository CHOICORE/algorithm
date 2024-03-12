/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        while (current != null) {
            prefixSum += current.val;

            if (prefixSumToNode.containsKey(prefixSum)) {
                ListNode prev = prefixSumToNode.get(prefixSum);
                current = prev.next;

                int p = prefixSum + current.val;
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    current = current.next;
                    p += current.val;
                }

                prev.next = current.next;
            } else {
                prefixSumToNode.put(prefixSum, current);
            }
            current = current.next;
        }
        return front.next;
    }
}