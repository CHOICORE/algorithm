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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;

        int sumOfDigits = 0;
        ListNode root = new ListNode(1);
        ListNode current = root;
        while (l1 != null || l2 != null) {

            if (l1 == null) {
                sumOfDigits = l2.val + carry;

                if (sumOfDigits >= 10) {

                    ListNode next = new ListNode(sumOfDigits - 10);
                    current.next = next;
                    current = next;
                    carry = 1;

                } else {

                    ListNode next = new ListNode(sumOfDigits);
                    current.next = next;
                    current = next;
                    carry = 0;

                }
                l2 = l2.next;
            } else if (l2 == null) {
                sumOfDigits = l1.val + carry;

                if (sumOfDigits >= 10) {
                    ListNode next = new ListNode(sumOfDigits - 10);
                    current.next = next;
                    current = next;
                    carry = 1;

                } else {

                    ListNode next = new ListNode(sumOfDigits);
                    current.next = next;
                    current = next;

                    carry = 0;

                }
                l1 = l1.next;

            } else {
                sumOfDigits = l1.val + l2.val + carry;

                if (sumOfDigits >= 10) {
                    ListNode next = new ListNode(sumOfDigits - 10);
                    current.next = next;
                    current = next;
                    carry = 1;

                } else {

                    ListNode next = new ListNode(sumOfDigits);
                    current.next = next;
                    current = next;
                    carry = 0;
                }
                l1 = l1.next;
                l2 = l2.next;

            }
        }


        if (carry != 0) {
            ListNode next = new ListNode(1);
            current.next = next;
        }

        return reverseList(root.next);

    }


    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;

            current.next = previous;
            previous = current;
            current = nextTemp;
        }

        return previous;

    }
}