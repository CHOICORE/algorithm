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
    public boolean isValidBST(TreeNode root) {
        return isValidCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidCheck(TreeNode root, long min, long max) {
        // 노드가 존재하지 않으면 true
        if (root == null) {
            return true;
        }
        // 노드가 최소값보다 작거나 같고 최대값보다 크거나 같으면 false
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidCheck(root.left, min, root.val) && 
               isValidCheck(root.right, root.val, max);
    }
}
