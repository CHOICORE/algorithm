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
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        Deque<TreeNode> currentRow = new ArrayDeque<>();
        Deque<TreeNode> nextRow = new ArrayDeque<>();
        nextRow.offerLast(root);
        int row = 0;

        while (true) {
            row++;
            currentRow = new ArrayDeque<>(nextRow);
            nextRow = new ArrayDeque<>();

            while (!currentRow.isEmpty()) {
                TreeNode node = currentRow.pollFirst();

                if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                    return row;
                }

                if (Objects.nonNull(node.left)) {
                    nextRow.offerLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    nextRow.offerLast(node.right);
                }


            }

        }
    }
}