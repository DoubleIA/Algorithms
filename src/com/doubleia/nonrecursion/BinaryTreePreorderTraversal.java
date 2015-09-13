package com.doubleia.nonrecursion;

import java.util.ArrayList;
import java.util.Stack;

import com.doubleia.binarysearchtree.TreeNode;

/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Given binary tree {1,#,2,3}:
 * 
 ** 1
 **  \
 **   2
 **  /
 ** 3
 *
 * return [1,2,3].
 * 
 * Can you do it without recursion?
 * 
 * @author wangyingbo
 *
 */
public class BinaryTreePreorderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
    	ArrayList<Integer> preorder = new ArrayList<Integer>();
    	
    	if (root == null)
    		return null;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode newRoot = stack.pop();
    		preorder.add(newRoot.val);
    		
    		if (newRoot.right != null)
    			stack.push(newRoot.right);
    		
    		if (newRoot.left != null)
    			stack.push(newRoot.left);
    	}
    	
    	
    	return preorder;
    }
    
    /**
     * 
     * Recursion:
     * 
     * public ArrayList<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> preorder) {
	    	if (root == null)
	    		return null;
	    	
	    	if (root.left != null) {
	    		preorder.add(root.left.val);
	    		preorderTraversal(root.left, preorder);
	    	}
	    	if (root.right != null) {
	    		preorder.add(root.right.val);
	    		preorderTraversal(root.right, preorder);
	    	}
	    	
	    	return preorder;
       }
     * 
     * 
     */
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		TreeNode c3 = new TreeNode(4);
		TreeNode c4 = new TreeNode(5);
		root.right = c1;
		root.left = c3;
		c1.left = c2;
		c3.right = c4;
		
		BinaryTreePreorderTraversal tree = new BinaryTreePreorderTraversal();
		ArrayList<Integer> preorder = tree.preorderTraversal(root);
		System.out.println(preorder);
	}
}
