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
    		TreeNode newRoot = stack.pop();
    		preorder.add(newRoot.val);
    		
    		if (newRoot.right != null)
    			stack.push(newRoot.right);
    		
    		if (newRoot.left != null)
    			stack.push(newRoot.left);
    	}
    	
    	System.out.println(preorder);
    }
}
