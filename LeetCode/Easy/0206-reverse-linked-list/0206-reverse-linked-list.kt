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
    fun reverseList(head: ListNode?): ListNode? {
        var head = head
        var prev: ListNode? = null
        var cur = head
        var next: ListNode? = null

        while (cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        head = prev
        return head
    }
}
