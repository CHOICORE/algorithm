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
    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next
            slow = slow.next
        }
        var prev = slow
        slow = slow!!.next
        prev!!.next = null
        while (slow != null) {
            val next = slow.next
            slow.next = prev
            prev = slow
            slow = next
        }
        slow = prev
        fast = head
        while (fast != null && slow != null) {
            if (fast.`val` != slow.`val`) {
                return false
            }
            fast = fast.next
            slow = slow.next
        }
        return true
    }
}
