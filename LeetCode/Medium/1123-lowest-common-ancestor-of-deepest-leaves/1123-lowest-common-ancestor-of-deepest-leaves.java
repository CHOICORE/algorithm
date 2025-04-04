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
    TreeNode answer;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // time o(n), space o(n)
        dfs(root, 0);
        return answer;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        if (left == right && left == maxDepth) answer = node;
        return Math.max(left, right);
    }
}