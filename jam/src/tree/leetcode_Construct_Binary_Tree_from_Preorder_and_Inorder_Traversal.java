package tree;

/*Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal
 leetcode

 Given preorder and inorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.
 */

class leetcode_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public static void main(String[] args) {
		// All test cases are pass in leetcode.
	}

	public static TreeNode buildTree(int[] pre, int[] in) {
		TreeNode root = new TreeNode(pre[0]);
		// Get the root index of current subtree (assume no duplicates!).
		int index = 0;
		for (; index < in.length; ++index) {
			if (in[index] == root.val) {
				break;
			}
		}
		// Create inorder & preorder for right child node.
		int[] right_in = new int[in.length - index - 1], right_pre = new int[in.length
				- index - 1];
		for (int i = index + 1; i < in.length; ++i) {
			right_in[i - index - 1] = in[i];
			right_pre[i - index - 1] = pre[i];
		}
		// Create inorder & preorder for left child node.
		int[] left_in = new int[index], left_pre = new int[index];

		for (int i = 0; i < index; ++i) {
			left_in[i] = in[i];
			left_pre[i] = pre[i + 1];
		}
		root.left = buildTree(left_pre, left_in);
		root.right = buildTree(right_pre, right_in);
		return root;
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int x) {
			this.left = null;
			this.right = null;
			this.val = x;
		}
	}

}

/*
 * Python Version def buildTree(self, preorder, inorder): if not preorder and
 * not inorder: return None
 * 
 * val = preorder[0] idx = inorder.index(val)
 * 
 * ret = TreeNode(val) ret.left = self.buildTree(preorder[1 : idx + 1],
 * inorder[:idx]) ret.right = self.buildTree(preorder[idx + 1:], inorder[idx +
 * 1:]) return ret
 */
