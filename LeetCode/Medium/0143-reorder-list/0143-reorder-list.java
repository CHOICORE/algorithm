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
    public static void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        reorderList(head, head.next);
    }

    public static ListNode reorderList(ListNode head, ListNode curr) {
        ListNode temp;
        if (curr.next != null) {
            temp = reorderList(head, curr.next);
        } else {
            temp = head;
        }
        if (temp == null) {
            return null;
        }
        if (temp == curr || temp.next == curr) {
            curr.next = null;
            return null;
        }

        curr.next = temp.next;
        temp.next = curr;
        return curr.next;
    }

}