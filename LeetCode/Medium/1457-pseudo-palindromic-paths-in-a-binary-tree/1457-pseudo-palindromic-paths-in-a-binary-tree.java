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
	int answer = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		preorder(root, 0);
		return answer;
	}

	void preorder(TreeNode node, int seen) {
		if (node == null) return;
		seen ^= (1 << node.val);
		if (node.left == null && node.right == null) {
			if ((seen & (seen - 1)) == 0) {
				answer++;
			}
			return;
		}
		preorder(node.left, seen);
		preorder(node.right, seen);

	}
}
