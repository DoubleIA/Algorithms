package com.doubleia.tree.binarytree;

/**
 * 
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1. 
 * 
 * T2 is a subtree of T1 in the following case:
 * 
 *           1                3
 *          / \              / 
 * T1 = 2   3  T2 =  4
 *   	       /
 *           4
 * 
 * T2 isn't a subtree of T1 in the following case:
 * 
 *           1               3
 *          / \               \
 * T1 = 2   3   T2 =    4
 *             /
 *            4
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
 * That is, if you cut off the tree at node n, the two trees would be identical.
 * 
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * 
 * @author wangyingbo
 *
 */
public class Subtree {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		// write your code here
		if (T2 == null)
			return true;
		if (T1 == null)
			return false;
		
		boolean record = false;
		if (T1.val == T2.val)
			record = isEqualTree(T1, T2);
		
		return isSubtree(T1.left, T2) || isSubtree(T1.right, T2) || record;
	}
	
	private boolean isEqualTree(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null)
			return true;
		else if (T1 == null || T2 == null || T1.val != T2.val)
			return false;
		else
			return isEqualTree(T1.left, T2.left) && isEqualTree(T1.right, T2.right);
	}

	public static void main(String[] args) {
		Subtree sub = new Subtree();
		TreeNode T1 = new TreeNode(1);
		TreeNode t11 = new TreeNode(2);
		TreeNode t12 = new TreeNode(3);
		TreeNode t13 = new TreeNode(4);
		TreeNode T2 = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		T1.left = t11;
		T1.right = t12;
		t12.left = t13;
		T2.left = t2;
		System.out.println(sub.isSubtree(T1, T2));
	}
}
