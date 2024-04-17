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
    String answer = "";
    public void traversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.insert(0, (char) (root.val + 97));
        if (root.left == null && root.right == null) {
            if (answer.equals("")) {
                answer = sb.toString();
            } else {
                answer = answer.compareTo(sb.toString()) > 0 ? sb.toString() : answer;
            }
        }
        traversal(root.left, sb);
        traversal(root.right, sb);
        sb.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        traversal(root, new StringBuilder());
        return answer;
    }
}