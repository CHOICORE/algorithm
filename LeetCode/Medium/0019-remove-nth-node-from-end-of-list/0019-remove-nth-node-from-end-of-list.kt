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
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        if (size == 1) {
            return null
        }
        if (size == 2) {
            if (n == 1) {
                head?.next = null
                return head
            }
            if (n == 2) {
                return head?.next
            }
            return head
        }
        if (size == n) {
            return head?.next
        }
        node = head
        for (i in 0..size - n - 2) {
            node = node?.next
        }
        node?.next = node?.next?.next
        return head
    }
}
