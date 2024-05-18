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
    int sum;

    public int distributeCoins(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return root.val - 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int total = left + right + root.val - 1;
        sum += Math.abs(left) + Math.abs(right);
        return total;
    }
}