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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (head != null) {
            if (head.next != null) {
                ListNode ls = new ListNode(head.next.val, new ListNode(head.val));
                result.next = ls;
                result = ls.next;
                head = head.next.next;

            } else {
                ListNode ls = new ListNode(head.val);
                result.next = ls;
                result = ls;
                head = head.next;
            }

        }
        return dummy.next;
    }
}