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
    public String smallestFromLeaf(TreeNode root) {
        String smallestString = "";
        Queue<Pair<TreeNode, String>> nodeQueue = new LinkedList<>();
        
        nodeQueue.add(new Pair<>(root, String.valueOf((char) (root.val + 'a'))));
        
        while (!nodeQueue.isEmpty()) {
            
            Pair<TreeNode, String> pair = nodeQueue.poll();
            TreeNode node = pair.getKey();
            String currentString = pair.getValue();
            
            if (node.left == null && node.right == null) {
                
                if (smallestString.isEmpty()) {
                    smallestString = currentString;
                } else {
                    smallestString = currentString.compareTo(smallestString) < 0 ? currentString : smallestString;
                }
            }
            
            if (node.left != null) {
                nodeQueue.add(new Pair<>(node.left, (char) (node.left.val + 'a') + currentString));
            }
            
            if (node.right != null) {
                nodeQueue.add(new Pair<>(node.right, (char) (node.right.val + 'a') + currentString));
            }
        }

        return smallestString;
    }
}