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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int first = -1;
        int last;
        int index = 1;
        int previous = -1;
        int min = Integer.MAX_VALUE;

        while (curr.next != null) {

            if (prev.val > curr.val && curr.val < curr.next.val || prev.val < curr.val && curr.val > curr.next.val) {

                if (previous == -1) {
                    first = index;
                    previous = index;
                } else {
                    if (min > index - previous) {
                        min = index - previous;
                    }

                    previous = index;
                }

            }

            index++;


            curr = curr.next;
            prev = prev.next;

        }

        last = previous;

        int max;
        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        } else {
            max = last - first;
            return new int[]{min, max};
        }

    }
}