package com.doubleia.srb.dfs;

import com.doubleia.tree.binarysearchtree.TreeNode;

/**
 * 
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 * 
 * Example:
 * 
 *                 1
 *                  \
 *        1          2
 *       / \          \
 *      2   5    =>    3
 *     / \   \          \
 *    3   4   6          4
 *                         \
 *                          5
 *                           \
 *                            6
 *
 * Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.
 * 
 * Do it in-place without any extra memory.
 * 
 * @author wangyingbo
 *
 */
public class FlattenBinaryTreeToLinkedList {
	/**
	 * @param root : a TreeNode, the root of the binary tree
	 * @return: nothing
	 */
	public void flatten(TreeNode root) {
		// write your code here
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode pre = curr.left;
				while (pre.right != null)
					pre = pre.right;
				pre.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}
	
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList flat = new FlattenBinaryTreeToLinkedList();
    	TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		TreeNode c3 = new TreeNode(4);
		TreeNode c4 = new TreeNode(5);
		TreeNode c5 = new TreeNode(6);
		TreeNode c6 = new TreeNode(7);
		TreeNode c7 = new TreeNode(8);
		root.left = c1;
		root.right = c2;
		c1.left = c3;
		c1.right = c4;
		c2.left = c5;
		c4.left = c6;
		c4.right = c7;
		flat.flatten(root);
		for (TreeNode curr = root; curr != null; curr = curr.right) {
			System.out.print(curr.val);
		}
	}
}
