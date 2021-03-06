package tree;

/*Sum_Root_to_Leaf_Numbers

 Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 could represent a number.
 An example is the root-to-leaf path 1->2->3 which represents the number 123.
 Find the total sum of all root-to-leaf numbers.
 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */

public class leetcode_Sum_Root_to_Leaf_Numbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(6);
		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		// First impression. DFS + tracking cur sum.
		return preorder(root, 0);
	}

	public static int preorder(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		} else {
			sum = sum * 10 + root.val;
			if (root.left == null && root.right == null) {
				return sum;
			} else {
				return preorder(root.left, sum) + preorder(root.right, sum);
			}
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

}

/*
 * Python Version def sumNumbers(self, root): def preorder(root, s): if not
 * root: return 0 else: s = s * 10 + root.val if not root.left and not
 * root.right: return s else: return preorder(root.left, s) +
 * preorder(root.right, s)
 * 
 * return preorder(root, 0)
 */
