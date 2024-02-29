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
    private int[] h;

    private boolean recursive(TreeNode root, int level) {
        if (root == null) {
            return true;
        }
        if ((level & 1) == 0) {
            if ((root.val & 1) == 0) {
                return false;
            }
            if (h[level] == 0) {
                h[level] = root.val;
            } else {
                if (h[level] >= root.val) {
                    return false;
                } else {
                    h[level] = root.val;
                }
            }
        } else {
            if ((root.val & 1) == 1) {
                return false;
            }
            if (h[level] == 0) {
                h[level] = root.val;
            } else {
                if (h[level] <= root.val) {
                    return false;
                } else {
                    h[level] = root.val;
                }
            }
        }
        return recursive(root.left, level + 1) && recursive(root.right, level + 1);
    }

    public boolean isEvenOddTree(TreeNode root) {
        h = new int[100001];
        return recursive(root, 0);
    }
}