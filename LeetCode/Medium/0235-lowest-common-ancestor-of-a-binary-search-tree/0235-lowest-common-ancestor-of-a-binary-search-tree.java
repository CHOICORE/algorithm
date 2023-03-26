/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

/*
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // 현재 노드가 없으면 null을 반환
        if (root == null) {
            return null;
        }
        // 만약 두 노드 p, q가 현재 노드보다 모두 작으면, LCA는 현재 노드의 왼쪽 서브트리에 있다.
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        // 만약 두 노드 p, q가 현재 노드보다 모두 크면, LCA는 현재 노드의 오른쪽 서브트리에 있다.
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        // 전부 아니라면 현재 노드가 LCA
        else {
            return root;
        }
    }
}
*/
