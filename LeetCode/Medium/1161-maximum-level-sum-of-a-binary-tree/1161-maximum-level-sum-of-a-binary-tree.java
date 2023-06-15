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
        if (root == null) {
            return 0;
        }
        int curSum = 0;
        int maxSum = root.val;
        int curLevel = 1;
        int maxLevel = 1;
        int curNodes = 1;
        int nextNodes = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            curNodes--;
            curSum += cur.val;
            if (cur.left != null) {
                q.add(cur.left);
                nextNodes++;
            }
            if (cur.right != null) {
                q.add(cur.right);
                nextNodes++;
            }
            if (curNodes == 0) {
                // System.out.println("level: "+curLevel+" | sum: "+curSum);
                if (maxSum < curSum) {
                    maxSum = curSum;
                    maxLevel = curLevel;
                }
                curNodes = nextNodes;
                nextNodes = 0;
                curSum = 0;
                curLevel++;
            }
        }
        return maxLevel;
    }
}