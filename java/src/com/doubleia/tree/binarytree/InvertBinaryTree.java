package com.doubleia.tree.binarytree;

import java.util.Stack;

import com.doubleia.tree.binarysearchtree.TreeNode;

/**
 * 
 * Invert a binary tree.
 * 
 *    1         1
 *   / \       / \
 *  2   3  => 3   2
 *     /       \
 *    4         4
 * 
 * 
 * Do it in recursion is acceptable, can you do it without recursion?
 * 
 * @author wangyingbo
 *
 */
public class InvertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
	public void invertBinaryTree(TreeNode root) {
		// write your code here
		if (root == null)
			return;
		
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		
		TreeNode temp = null;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			TreeNode right = temp.right;
			invert(temp);
			if (right != null) {
				temp = right;
				stack.push(right);
				while (right.left != null) {
					right = right.left;
					stack.push(right);
				}
			}
		}
		
	}
	
	private void invert(TreeNode temp) {
		TreeNode tmp = temp.left;
		temp.left = temp.right;
		temp.right = tmp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		TreeNode c4 = new TreeNode(4);
		root.left = c1;
		c1.right = c2;
		c1.left = c4;
		BinaryTree.preorderTraversal(root);
		InvertBinaryTree in = new InvertBinaryTree();
		in.invertBinaryTree(root);
		BinaryTree.preorderTraversal(root);
	}
	
	/**
	 * 
	 * recursion
	 * 
	 *public void invertBinaryTree(TreeNode root) {
		// write your code here
		if (root.left == null && root.right == null)
			return;
		else if (root.left != null && root.right == null) {
			invertBinaryTree(root.left);
			root.right = root.left;
			root.left = null;
		} else if (root.right != null && root.left == null) {
			invertBinaryTree(root.right);
			root.left = root.right;
			root.right = null;
		} else {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertBinaryTree(root.left);
			invertBinaryTree(root.right);
		}
		
	}
	 * 
	 */
}
