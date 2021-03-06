package tree;

/*Maximum_Depth_of_Binary_Tree

 Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root
 node down to the farthest leaf node.
 */

public class leetcode_Maximum_Depth_of_Binary_Tree {

	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}
}

/*
 * Python Version def maxDepth(self, root): return o if not root else
 * max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
 */
