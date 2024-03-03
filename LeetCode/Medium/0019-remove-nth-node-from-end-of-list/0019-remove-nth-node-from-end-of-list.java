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
        int length = findLength(head);
        int i = 0, traverseTill = length - n - 1;
        if (traverseTill == -1) return head.next;
        ListNode cur = head;
        while (i < traverseTill) {
            cur = cur.next;
            i++;
        }
        cur.next = cur.next.next;
        return head;
    }

    public int findLength(ListNode head) {
        int count = 0;
        if (head == null) return count;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
