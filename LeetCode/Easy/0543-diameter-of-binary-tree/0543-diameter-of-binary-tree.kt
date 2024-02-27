/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var result: Int = kotlin.Int.Companion.MIN_VALUE

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return result
    }

    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = depth(node.left)
        val rightDepth = depth(node.right)

        val currrentD = leftDepth + rightDepth
        result = max(result, currrentD)

        return max(leftDepth, rightDepth) + 1
    }
}