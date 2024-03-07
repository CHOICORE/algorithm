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
    fun middleNode(head: ListNode?): ListNode? {
        var head: ListNode? = head
        var temp: ListNode? = head
        var size = 0
        while (temp != null) {
            temp = temp.next
            size++
        }
        temp = head
        for (i in 0 until size / 2) {
            temp = temp!!.next
        }
        head = temp
        return head
    }
}
