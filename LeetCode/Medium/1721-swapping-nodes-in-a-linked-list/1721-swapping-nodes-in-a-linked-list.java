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
        ListNode temp = head;
        ListNode rtemp = head;
        ListNode ctemp = head;
        int cnt = 1;
        while (cnt < k) {
            rtemp = rtemp.next;
            ctemp = ctemp.next;
            cnt++;
        }
        while (rtemp.next != null) {
            temp = temp.next;
            rtemp = rtemp.next;
        }
        int d = temp.val;
        temp.val = ctemp.val;
        ctemp.val = d;
        return head;

    }
}