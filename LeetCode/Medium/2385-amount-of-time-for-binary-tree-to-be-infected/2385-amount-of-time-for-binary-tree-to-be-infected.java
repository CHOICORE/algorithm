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
    private int answer;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return answer;
    }

    public int dfs(TreeNode root, int start) {
        if (root == null) return 0;

        int left = dfs(root.left, start);
        int right = dfs(root.right, start);

        if (root.val == start) {
            answer = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            answer = Math.max(answer, Math.abs(left - right));
            return Math.min(left, right) - 1;
        }
    }
}