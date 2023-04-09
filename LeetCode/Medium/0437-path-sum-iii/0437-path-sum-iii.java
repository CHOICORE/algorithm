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
    int count;
    Map<Long, Integer> freq;

    public void dfs(TreeNode root, int targetSum, long sum) {
        if (root == null) return;
        
        long tmp = sum + root.val;
        if (freq.containsKey(tmp - targetSum)) {
            count += freq.get(tmp - targetSum);
        }
        freq.put(tmp, freq.getOrDefault(tmp, 0) + 1);
        dfs(root.left, targetSum, tmp);
        dfs(root.right, targetSum, tmp);
        freq.put(tmp, freq.get(tmp) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        freq = new HashMap<>();
        freq.put(0L, 1);
        dfs(root, targetSum, 0L);
        return count;
    }
}
