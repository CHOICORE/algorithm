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

    public TreeNode reverseOddLevels(TreeNode root) {
        traverse(root.left, root.right, 0);
        return root;
    }

    private void traverse(
            TreeNode leftChild,
            TreeNode rightChild,
            int level
    ) {
        if (leftChild == null || rightChild == null) {
            return;
        }
        
        if (level % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        traverse(leftChild.left, rightChild.right, level + 1);
        traverse(leftChild.right, rightChild.left, level + 1);
    }
}