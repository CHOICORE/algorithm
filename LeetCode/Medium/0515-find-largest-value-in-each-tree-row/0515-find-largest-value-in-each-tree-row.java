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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<Integer>();

        if (root == null) return max;
        
        calc(root, max, 0);
        return max;
    }

    public void calc(TreeNode root, List<Integer> max, int depth) {

        if (root == null) {
            return;
        }

        if (max.size() <= depth) {
            max.add(root.val);
        } else if (max.get(depth) < root.val) {
            max.set(depth, root.val);
        }

        calc(root.left, max, depth + 1);
        calc(root.right, max, depth + 1);
    }
}