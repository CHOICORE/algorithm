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
    private List<TreeNode>[][] dp;

    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n + 1][n + 1];
        int low = 1;
        int high = n;
        return generateTrees(low, high);
    }

    public List<TreeNode> generateTrees(int low, int high) {
        final List<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        if (dp[low][high] != null) {
            return dp[low][high];
        }
        for (int i = low; i <= high; i++) {
            final List<TreeNode> left = generateTrees(low, i - 1);
            final List<TreeNode> right = generateTrees(i + 1, high);
            for (int l = 0; l < left.size(); l++) {
                for (int r = 0; r < right.size(); r++) {
                    final TreeNode root = new TreeNode(i);
                    root.left = left.get(l);
                    root.right = right.get(r);
                    res.add(root);
                }
            }
        }
        dp[low][high] = res;
        return res;
    }
}