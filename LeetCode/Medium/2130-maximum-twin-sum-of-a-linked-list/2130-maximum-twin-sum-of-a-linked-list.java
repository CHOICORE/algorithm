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
    public int pairSum(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode slow = head, fast = head.next;
        stack.push(slow.val);
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        slow = slow.next;
        int maxSum = 0;
        while (slow != null) {
            maxSum = Math.max(maxSum, slow.val + stack.pop());
            slow = slow.next;
        }
        return maxSum;
    }
}