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
    fun isSameTree(
        p: TreeNode?,
        q: TreeNode?,
    ): Boolean {
        return dfs(p, q)
    }

    fun dfs(
        p: TreeNode?,
        q: TreeNode?,
    ): Boolean {
        if (p == null || q == null) return q == p

        return p?.`val`!! == q?.`val`!! &&
            dfs(p?.left, q?.left) &&
            dfs(p?.right, q?.right)
    }
}
