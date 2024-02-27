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
    int diameter = 0;

    public int hieght(TreeNode root) {
        if (root == null) return 0;
        int left = hieght(root.left);
        int right = hieght(root.right);
        int dia = left + right + 1;
        diameter = Math.max(dia, diameter);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        hieght(root);
        System.gc();
        return diameter - 1;
    }
}