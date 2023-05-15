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
    public ListNode swapNodes(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode len = head;
        int length = 0;

        // calculate length
        while (len != null) {
            len = len.next;
            length++;
        }


        ListNode curr1 = head;
        ListNode curr2 = head;

        int l = length - k;

        //finding left node
        while (k-- > 1) {
            curr1 = curr1.next;
        }

        // finding right node
        while (l-- > 0) {
            curr2 = curr2.next;
        }

        // edge cases like k is the middle node then no need to swap
        if (curr1 == curr2) return head;


        // Swapping Values of both indexes

        curr1.val = curr1.val + curr2.val;
        curr2.val = curr1.val - curr2.val;
        curr1.val = curr1.val - curr2.val;

        return head;
    }
}