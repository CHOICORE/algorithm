/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int total = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        findSum(root, 0L, (long) targetSum, map);
        return total;

    }

    private void findSum(TreeNode curr, Long sum, Long target, HashMap<Long, Integer> hm) {
        if (curr == null) return;
        
        sum += curr.val;
        if (hm.containsKey(sum - target)) {
            total += hm.get(sum - target);
        }
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        findSum(curr.left, sum, target, hm);
        findSum(curr.right, sum, target, hm);
        hm.put(sum, hm.get(sum) - 1);
        return;
    }
}