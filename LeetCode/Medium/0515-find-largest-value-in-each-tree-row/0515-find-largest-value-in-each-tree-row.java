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
    List<Integer> answer;

    public List<Integer> largestValues(TreeNode root) {
        answer = new ArrayList<>();
        dfs(root, 0);
        return answer;
    }

    private void dfs(TreeNode node, int l) {
        if (node != null) {
            int v = node.val;
            if (l == answer.size()) {
                answer.add(v);
            } else {
                answer.set(l, Math.max(answer.get(l), v));
            }
            dfs(node.left, l + 1);
            dfs(node.right, l + 1);
        }
    }
}