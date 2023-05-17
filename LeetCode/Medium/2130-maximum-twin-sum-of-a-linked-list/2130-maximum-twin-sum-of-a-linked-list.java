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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        List<Integer> values = new ArrayList<>();

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int i = 0, j = values.size() - 1;
        int maxSum = 0;
        while (i < j) {
            maxSum = Math.max(maxSum, values.get(i) + values.get(j));
            i++;
            j--;
        }

        return maxSum;
    }
}