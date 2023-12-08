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
    private static void convert(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }

        sb.append('(');
        convert(root.left, sb);
        sb.append(')');

        if (root.right != null) {
            sb.append('(');
            convert(root.right, sb);
            sb.append(')');
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        convert(t, sb);

        return sb.toString();
    }
}