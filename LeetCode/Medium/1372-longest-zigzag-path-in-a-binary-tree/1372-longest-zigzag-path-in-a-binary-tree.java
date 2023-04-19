/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int longestZigZagPath = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return longestZigZagPath;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) {
            longestZigZagPath = Math.max(longestZigZagPath, length - 1);
            return;
        }
        if (isLeft) {
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);
        } else {
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);
        }
    }
}
