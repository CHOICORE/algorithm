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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        
        if (root == null) {
            return answer;
        }
        
        Stack<TreeNode> mainStack = new Stack<>();
        Stack<TreeNode> pathStack = new Stack<>();
        
        mainStack.push(root);
        
        while (!mainStack.isEmpty()) {
            root = mainStack.peek();
            
            if (!pathStack.isEmpty() && pathStack.peek() == root) {
                answer.add(root.val);
                mainStack.pop();
                pathStack.pop();
            } else {
                pathStack.push(root);
                if (root.right != null) {
                    mainStack.push(root.right);
                }
                if (root.left != null) {
                    mainStack.push(root.left);
                }
            }
        }

        return answer;
    }
}