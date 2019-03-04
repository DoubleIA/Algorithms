package com.doubleia.tree.binarytree;

import java.util.ArrayList;

import com.doubleia.tree.binarysearchtree.TreeNode;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Given binary tree {1,#,2,3},
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 *    
 * return [1,3,2].
 * 
 * Can you do it without recursion?
 * 
 * @author wangyingbo
 *
 */
public class BinaryTreeInorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// write your code here
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if (root == null)
			return arr;
		
		TreeNode curr = root;
		TreeNode pre = null;
		while (curr != null) {
			if (curr.left == null) {
				arr.add(curr.val);
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre = null;
					arr.add(curr.val);
					curr = curr.right;
				}
			}
		}
		
		return arr;
	}
	
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
		BinaryTreeInorderTraversal bin = new BinaryTreeInorderTraversal();
		System.out.println(bin.inorderTraversal(root));
	}
}
