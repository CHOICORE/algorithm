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
    fun hasCycle(head: ListNode?): Boolean {
        var isCircle: Boolean = false

        var slow = head
        var fast = head?.next
        while (slow != null && fast != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                isCircle = true
                return isCircle
            }
        }

        return isCircle
    }
}
