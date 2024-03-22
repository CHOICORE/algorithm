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
        val array = IntArray(100000)
        
        if (head == null || head.next == null) {
            return true
        }
        var h: ListNode? = head
        val array1 = array
        var size = 0

        while (h != null) {
            array1[size++] = h.`val`
            h = h.next
        }

        val m = size / 2
        for (i in 0 until m) {
            if (array[i] != array1[--size]) {
                return false
            }
        }
        return true
    }
}
