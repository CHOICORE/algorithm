/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val start: ListNode = ListNode(0)
        start.next = head

        var slow: ListNode = start
        var fast: ListNode = start

        for (gap in 0 until n) {
            fast = fast.next
        }
        while (fast.next != null) {
            slow = slow.next
            fast = fast.next
        }

        slow.next = slow.next.next
        return start.next
    }
}