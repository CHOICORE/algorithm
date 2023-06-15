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
    static int level;

    public int maxLevelSum(TreeNode root) {
        level = 1;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int nodes = 1;
        getResult(max, nodes, q, 1);
        return level;
    }

    void getResult(int max, int nodes, Queue<TreeNode> q, int step) {
        if (q.isEmpty()) {
            return;
        }

        int temp = 0;
        int child = 0;
        while (nodes > 0) {
            TreeNode t = q.poll();
            if (t.left != null) {
                q.add(t.left);
                child++;
            }
            if (t.right != null) {
                q.add(t.right);
                child++;
            }
            temp += t.val;
            nodes--;
        }
        if (temp > max) {
            level = step;
            max = temp;
        }
        getResult(max, child, q, step + 1);
    }
}