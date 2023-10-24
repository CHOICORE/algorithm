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
        if (root == null) return new ArrayList<>();
        List<Integer> largestValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();

            int largestValue = Integer.MIN_VALUE;

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();

                largestValue = Math.max(largestValue, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            largestValues.add(largestValue);

        }

        return largestValues;

    }
}
