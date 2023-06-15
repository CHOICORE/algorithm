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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long maxSum = Long.MIN_VALUE;
        int level = 0, ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            long count = 0;
            while (size > 0) {
                size--;
                TreeNode n = q.poll();
                count += n.val;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            if (count > maxSum) {
                ans = level;
                maxSum = count;
            }
        }
        return ans;
    }

}