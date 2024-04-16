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
    public TreeNode helper(TreeNode root, int val, int depth, int cur) {
        if (depth == 1) {
            TreeNode zoo = new TreeNode(val);
            zoo.left = root;
            return zoo;
        }

        if (root == null) {
            return root;
        }

        if (cur == depth - 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = left;
            root.right.right = right;
            return root;

        }

        helper(root.left, val, depth, cur + 1);
        helper(root.right, val, depth, cur + 1);

        return root;

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helper(root, val, depth, 1);


    }
}