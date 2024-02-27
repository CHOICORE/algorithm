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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return diameter
    }

    var diameter = 0

    fun maxDepth(node: TreeNode?): Int {
        node ?: return 0

        val left = maxDepth(node.left)
        val right = maxDepth(node.right)

        diameter = max(diameter, left + right)

        return max(left, right) + 1
    }
}
