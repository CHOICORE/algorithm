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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int len = count - n;

        if (len == 0) {
            head = head.next;
        } else {
            ListNode prev = head;
            while (len - 1 != 0) {
                prev = prev.next;
                len--;
            }
            prev.next = prev.next.next;
        }

        return head;
    }
}