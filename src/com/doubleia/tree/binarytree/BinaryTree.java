package com.doubleia.tree.binarytree;

import java.util.ArrayList;
import java.util.Stack;

import com.doubleia.tree.binarysearchtree.TreeNode;

public class BinaryTree {
	public static void preorderTraversal(TreeNode root) {
        // write your code here
    	ArrayList<Integer> preorder = new ArrayList<Integer>();
    	
    	if (root == null)
    		System.out.println(preorder);
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode curr = stack.pop();
    		preorder.add(curr.val);
    		
    		if (curr.right != null)
    			stack.push(curr.right);
    		if (curr.left != null)
    			stack.push(curr.left);
    	}
    	
    	System.out.println(preorder);
    }
	
	public static void inorderTraversal(TreeNode root) {
		ArrayList<Integer> inorder = new ArrayList<Integer>();
    	
    	if (root == null)
    		System.out.println(inorder);
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curr = root;
    	
    	while (curr != null) {
    		stack.push(curr);
    		curr = curr.left;
    	}
    	
    	while (!stack.isEmpty()) {
    		curr = stack.pop();
    		inorder.add(curr.val);
    		if (curr.right != null) {
    			curr = curr.right;
    			stack.push(curr);
    			while (curr.left != null) {
    				stack.push(curr.left);
    				curr = curr.left;
    			}
    		}
    	}
    	
    	System.out.println(inorder);
	}
	
	public static void postorderTraversal(TreeNode root) {
		ArrayList<Integer> postorder = new ArrayList<Integer>();
    	
    	if (root == null)
    		System.out.println(postorder);
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<Integer> sign = new Stack<Integer>();
    	TreeNode curr = root;
    	
    	while (curr != null) {
    		stack.push(curr);
    		sign.push(0);
    		curr = curr.left;
    	}
    	
    	int right;
    	while (!stack.isEmpty()) {
    		curr = stack.peek();
    		right = sign.peek();
    		if (curr.right != null && right == 0) {
    			sign.pop();
    			sign.push(1);
    			curr = curr.right;
    			while (curr != null) {
    				stack.push(curr);
    				sign.push(0);
    				curr = curr.left;
    			}
    		} else {
    			stack.pop();
    			sign.pop();
    			postorder.add(curr.val);
    		}
    	}
    	
    	System.out.println(postorder);
	}
	
	public static void preorderMorrisTraversal(TreeNode root) {
		
	}
	
	public static void inorderMorrisTraversal(TreeNode root) {
		
	}
	
	public static void postorderMorrisTraversal(TreeNode root) {
		
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
		// result : [6, 2, 1, 4, 3, 5, 9, 8]
		BinaryTree.preorderTraversal(root);
		// result : [1, 2, 3, 4, 5, 6, 8, 9]
		BinaryTree.inorderTraversal(root);
		// result : [1, 3, 5, 4, 2, 8, 9, 6]
		BinaryTree.postorderTraversal(root);
	}

}
