package com.doubleia.srb.dfs;

/**
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Given a binary tree as follow:
 * 
 *      1
 *     / \ 
 *    2   3
 *   / \
 *  4   5
 * 
 * The minimum depth is 2.
 * 
 * @author wangyingbo
 *
 */
public class MinimumDepthOfBinaryTree {
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer.
	 */
	public int minDepth(TreeNode root) {
		// write your code here
		if (root == null)
			return 0;
		return min(root, 1);
	}
	
	private int min(TreeNode root, int depth) {
		if (root.left != null && root.right != null) {
			return Math.min(min(root.left, depth + 1), min(root.right, depth + 1));
		} else if (root.left != null) {
			return min(root.left, ++depth);
		} else if (root.right != null) {
			return min(root.right, ++depth);
		} else {
			return depth;
		}
	}
	
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree min = new MinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode _2l = new TreeNode(4);
		root.right = right;
		root.left = left;
		left.left = _2l;
		System.out.println(min.minDepth(root));
	}
}
