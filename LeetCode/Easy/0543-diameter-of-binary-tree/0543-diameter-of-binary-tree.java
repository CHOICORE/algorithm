/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        helperFunction(root, max);
        return max[0];
    }

    public static int helperFunction(TreeNode root, int[] max) {
        if (root == null) return 0;

        int leftHeight = helperFunction(root.left, max);
        int rightHeight = helperFunction(root.right, max);
        max[0] = Math.max(max[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}