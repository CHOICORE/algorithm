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
public class Solution {
    int x = 0;

    int count(ListNode root) {
        ListNode temp = root;
        while (temp != null) {
            temp = temp.next;
            x++;
        }
        return x;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = count(head);
        int x = n / k, y = n % k;
        ListNode[] v = new ListNode[k];
        ListNode a = head, b = null;
        for (int i = 0; i < k; i++) {
            v[i] = head;
            for (int j = 0; j < x + (i < y ? 1 : 0); j++) {
                b = head;
                head = head.next;
            }
            if (b != null) {
                b.next = null;
            }
        }
        return v;
    }
}