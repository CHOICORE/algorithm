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
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        Stack<TreeNode> next_nodes = new Stack<TreeNode>();
        int level = 1;
        while (!nodes.empty()) {
            while (!nodes.empty()) {
                TreeNode node = nodes.peek();
                nodes.pop();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) next_nodes.push(node.left);
                if (node.right != null) next_nodes.push(node.right);
            }
            nodes = next_nodes;
            next_nodes = new Stack<TreeNode>();
            level++;
        }
        return level;
    }
}