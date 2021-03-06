package tree;

/*Longest_Path

 Given a tree, return the number of nodes in its the longest path.
 */

import java.util.Arrays;

public class google_Longest_Path {
	public static void main(String[] args) {

	}
}

class Solution {
	private TreeNode root;
	private int size;
	private int longest;

	Solution(TreeNode root) {
		this.root = root;
	}

	public int longestPath() {
		nextNode(root);
		return this.longest;
	}

	public int nextNode(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int[] arr = new int[size];
		for (int i = 0; i < size; ++i) {
			arr[i] = nextNode(node.kids[i]);
		}
		int localMax = 0;
		Arrays.sort(arr);
		int max1 = arr[0];
		int max2 = arr[1];
		this.longest = Math.max(this.longest, max1 + max2 + 1);
		return Math.max(max1 + 1, max2 + 1);
	}

	static class BinaryTree {
		// Solution for binary tree
		private int longest;

		public int maxPathSum(TreeNode root) {
			this.longest = 0;
			nextPath(root);
			return this.longest;
		}

		private int nextPath(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int left = nextPath(root.left);
			int right = nextPath(root.right);
			this.longest = Math.max(this.longest, left + right + 1); // Update
																		// longest.
			// return the longest path starting with root and ending with a
			// leaf.
			return Math.max(left + 1, right + 1);
		}
	}

	static class TreeNode {
		private int capacity;
		public TreeNode[] kids;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			this.capacity = x;
			kids = new TreeNode[x];
			for (int i = 0; i < x; ++i) {
				kids[i] = null;
			}
		}

		public int kidsSize() {
			return capacity;
		}
	}

}
