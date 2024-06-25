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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        traversal(root, list);
        int sum = 0;
        for (TreeNode x : list) {
            sum = sum + x.val;
            x.val = sum;
        }
        return root;
    }

    public void traversal(TreeNode root, List<TreeNode> list) {
        if (root.right != null) traversal(root.right, list);
        list.add(root);
        if (root.left != null) traversal(root.left, list);
    }
}