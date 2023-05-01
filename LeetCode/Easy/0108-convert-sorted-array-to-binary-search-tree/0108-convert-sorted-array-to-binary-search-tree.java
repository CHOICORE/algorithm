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
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length - 1);
    }

    public TreeNode inorder(int nums[], int beg, int end) {
        int mid = (beg + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (beg > end) {
            return null;
        }

        root.left = inorder(nums, beg, mid - 1);
        root.right = inorder(nums, mid + 1, end);
        return root;


    }
}
