package com.doubleia.tree.binarysearchtree;

/**
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * * * The left subtree of a node contains only nodes with keys less than the node's key.
 * * * The right subtree of a node contains only nodes with keys greater than the node's key.
 * * * Both the left and right subtrees must also be binary search trees.
 * 
 * @author wangyingbo
 *
 */
public class ValidateBST {
	/**
	 * @param root : The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		// write your code here
		if (root == null)
			return true;
		
		if (root.left != null && root.right != null)
			if (root.val > max(root.left) && root.val < min(root.right))
				return isValidBST(root.right) && isValidBST(root.left);
			else
				return false;
		else if (root.left == null && root.right != null)
			if (root.val < min(root.right))
				return isValidBST(root.right);
			else
				return false;
		else if (root.left != null && root.right == null)
			if (root.val > max(root.left))
				return isValidBST(root.left);
			else
				return false;
		else
			return true;
			
	}
	
	private int max(TreeNode node) {
		while (node.right != null)
			node = node.right;
		return node.val;
	}
	
	private int min(TreeNode node) {
		while (node.left != null)
			node = node.left;
		return node.val;
	}
	
	//{989,982,#,972,#,947,#,920,#,903,#,894,#,881,#,866,#,864,#,842,#,841,#,796,#,726,#,647,#,613,719,593,#,#,#,590,#,558,#,554,#,538,#,512,#,504,#,468,505,467,#,#,#,456,#,413,#,331,#,330,407,320,#,#,#,312,#,306,#,301,#,274,#,251,#,235,#,231,#,222,#,181,#,93,#,83,#,73,#,64,#,62,#,60,#,28,#,21,#,20,#,-32,#,-52,#,-70,#,-87,#,-98,#,-102,#,-115,#,-116,#,-139,#,-183,#,-224,#,-241,#,-263,#,-284,#,-294,#,-296,#,-320,#,-330,#,-392,#,-398,#,-407,#,-431,#,-445,#,-460,#,-463,#,-492,#,-507,#,-518,#,-539,#,-552,#,-558,#,559,#,-587,#,-673,#,-736,#,-757,#,-766,#,-767,#,-823,#,-830,#,-867,#,-875,#,-891,#,-905,#,-910,#,-924,#,-960,#,-985,#,-988}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(9);
		TreeNode c3 = new TreeNode(1);
		TreeNode c4 = new TreeNode(4);
		TreeNode c5 = new TreeNode(8);
		TreeNode c6 = new TreeNode(3);
		TreeNode c7 = new TreeNode(5);
		root.left = c1;
		root.right = c2;
		c1.left = c3;
		c1.right = c4;
		c2.left = c5;
		c4.left = c6;
		c4.right = c7;
		ValidateBST bst = new ValidateBST();
		if (bst.isValidBST(root))
			BinarySearchTree.inorderMorrisTraversal(root);
		else
			System.out.println("invalidate bst");
	}
}
