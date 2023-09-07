/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (head.next == null) return head;
        int index = 0;
        ListNode leftNode = null, leftBehind = null, rightNode = null;
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode dummy = ans.next;

        while (dummy != null) {
            index++;
            if (index + 1 == left)
                leftBehind = dummy;
            if (index == left)
                leftNode = dummy;
            if (index == right)
                rightNode = dummy;
            dummy = dummy.next;
        }
        if (leftBehind != null)
            leftBehind.next = null;
        ListNode rightFront = (rightNode.next != null) ? rightNode.next : null;
        if (rightFront != null)
            rightNode.next = null;
        ListNode reverse = reverseList(leftNode);
        if (leftBehind != null)
            leftBehind.next = reverse;
        if (rightFront != null)
            leftNode.next = rightFront;
        if (left == 1)
            return reverse;
        return ans.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode currentNext = null;
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }

        return previous;
    }
}