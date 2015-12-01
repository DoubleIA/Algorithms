package com.doubleia.dp;

/**
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * Given the below binary tree:
 * 
 *   1
 *  / \
 * 2   3
 * 
 * return 6.
 * 
 * @author wangyingbo
 *
 */
public class BinaryTreeMaximumPathSum {
	private int maxsum = Integer.MIN_VALUE;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	public int maxPathSum(TreeNode root) {
		// write your code here
		if (root == null)
			return 0;
		maxsum(root);
		return maxsum;
	}
	
	private int maxsum(TreeNode root) {
		if (root == null)
			return 0;
		
		int leftSum = maxsum(root.left);
		int rightSum = maxsum(root.right);
		
		int sum = root.val;
		if (leftSum > 0)
			sum += leftSum;
		if (rightSum > 0)
			sum += rightSum;
		
		maxsum = Math.max(sum, maxsum);
		
		return (Math.max(leftSum, rightSum) > 0) ? (Math.max(leftSum, rightSum) + root.val) : root.val;
	}
	
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum bin = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode rleft = new TreeNode(4);
		root.left = left;
		root.right = right;
		right.left = rleft;
		System.out.println(bin.maxPathSum(root));
	}
}
