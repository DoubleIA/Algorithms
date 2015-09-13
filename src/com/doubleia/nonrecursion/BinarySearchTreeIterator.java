package com.doubleia.nonrecursion;

import java.util.ArrayList;

import com.doubleia.binarysearchtree.TreeNode;

/**
 * 
 * Design an iterator over a binary search tree with the following rules:
 * 
 **  Elements are visited in ascending order (i.e. an in-order traversal)
 **  next() and hasNext() queries run in O(1) time in average. 
 * 
 * For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
 * 
 **      10
 **    /    \
 **   1      11
 **    \       \
 **     6       12
 * 
 * Challenge
 * Extra memory usage O(h), h is the height of the tree.
 * 
 * Super Star: Extra memory usage O(1)
 * 
 * * * * * * * * * * * * * * * * * * * * * * * *
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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 * 
 * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 * @author wangyingbo
 *
 */
public class BinarySearchTreeIterator {
	//Can not solve this problem with extra memory usage O(1)
	
	//@param root: The root of binary tree.
    public BinarySearchTreeIterator(TreeNode root) {
        // write your code here
    	
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
    	return false;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
    	return null;
    }
    
    /**
     * 
     * Extra memory usage O(h), h is the height of the tree.
     * 
	 * public BinarySearchTreeIterator(TreeNode root) {
	        // write your code here
	    	while (!stack.isEmpty()) {
	    		stack.pop();
	    	}
	    	while (root != null) {
	    		stack.push(root);
	    		root = root.left;
	    	}
	    }
	
	    //@return: True if there has next node, or false
	    public boolean hasNext() {
	        // write your code here
	    	return !stack.isEmpty();
	    }
	    
	    //@return: return next node
	    public TreeNode next() {
	        // write your code here
	    	TreeNode temp = stack.peek();
	    	TreeNode next = stack.pop();
	    	temp = temp.right;
	    	while (temp != null) {
	    		stack.push(temp);
	    		temp = temp.left;
	    	}
	    	
	    	return next;
	    }
     * 
     */
    
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
		
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		
		BinarySearchTreeIterator iter = new BinarySearchTreeIterator(root);
		
		while(iter.hasNext()) {
			TreeNode node = iter.next();
			inOrder.add(node.val);
		}
		
		System.out.println(inOrder);
	}
}
