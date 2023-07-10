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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;

        return minDepthAux(root, root);
    }

    public int minDepthAux(TreeNode root, TreeNode curr) {
        if (curr == null) {
            return 0;
        } else {
            int left = minDepth(root.left) + 1;
            if (root == curr && left == 2) return 2;

            int right = minDepth(root.right) + 1;
            if (root == curr && right == 2) return 2;

            if ((left > 1 && left < right) || right == 1) return left;
            else return right;
        }
    }
}